package com.beta.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beta.entity.EmployeeBean;
import com.beta.validations.EmployeeValidator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BetaController {

	@Autowired
	private RestTemplate template;
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/home")
	public String showHomePage() {
		return "home"; // return logical view name to viewreslover
	}// end of method

	@GetMapping("/showAllEmployee")
	public String showAllEmployee(Map<String, Object> map) throws Exception {

		//String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/showById/{id}";

		String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/showAllEmployees";
		//http://192.168.0.163:4000/crudApi/showAllEmployees
		//String serviceUrl="http://192.168.0.163:4000/crudApi/showAllEmployees";
		
		ResponseEntity<String> resp = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);

		String JsonRespBody = resp.getBody();
		// convert json response body to List<EmployeeBean object>(list of model object)
		ObjectMapper mapper = new ObjectMapper();
		List<EmployeeBean> employeeList = mapper.readValue(JsonRespBody, new TypeReference<List<EmployeeBean>>() {
		});
		// keep results in MAp collection as model attributes-->
		// model data set will travel with request
		map.put("empData", employeeList);

		// returning Logical view name to view resolver
		return "employee_page";
	}// end of method

	// to launch eployee Registration form and add employee

	@GetMapping("/add")
	public String registerEmployee(@ModelAttribute("empData") EmployeeBean emp) {
		System.out.println("BetaController.registerEmployee()");
		return "register_employee";
	}// end of method

	@PostMapping("/add")
	public String registerEmployee(RedirectAttributes attrs, 
			@ModelAttribute("empData") EmployeeBean employee,
			BindingResult errors)
			throws Exception {
		System.out.println("BetaController.registerTourist()");
		
		//checking for typemismatch errors
		if(errors.hasFieldErrors())
			return "register_employee";
		
		//chekcing form vlaidation errors
		if(empValidator.supports(employee.getClass())) {
			empValidator.validate(employee, errors); 
			if(errors.hasErrors())
				return "register_employee";
		}//end of if case
		
		
		
		//this is preparation for rest operation
		// converting received object to JSON data using jackson api
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(employee);
		// invoke Spring rest service

	//	String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/save";
		String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/save";

		// prepare HttpEntity object(headers + body)
		// preparing headers n theen add json data in entity
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);

		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);

		String result = response.getBody();
		attrs.addFlashAttribute("result", result);

		return "redirect:showAllEmployee";
	}// end of method

	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("id") Integer empId, @ModelAttribute("empData") EmployeeBean employee)
			throws Exception {

		// invoke rest method
	//	String serviceurl = "http://lmipl-157.bbrouter:4000/crudApi/showById/{id}";
		String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/showById/{id}";

		
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class, empId);

		// get json body from response
		String jsonBody = response.getBody();
		// convert jsonbody to EmplooyeBean object
		EmployeeBean Tempemployee = mapper.readValue(jsonBody, EmployeeBean.class);
		BeanUtils.copyProperties(Tempemployee, employee);
		return "edit_employee";
	}// end of method

	@PostMapping("/edit")
	public String editTourist(RedirectAttributes attrs, @ModelAttribute("empData") EmployeeBean employee
			,BindingResult errors)
			throws Exception {
		System.out.println("BetaController.editTourist()");
		
		//checking for typemismatch errors
		if(errors.hasFieldErrors())
			return "edit_employee";
		
		//chekcing form vlaidation errors
		if(empValidator.supports(employee.getClass())) {
			empValidator.validate(employee, errors); 
			if(errors.hasErrors())
				return "edit_employee";
		}//end of if case
	
		
		// Convert object to jackson data using jackson api
		String jsonData = mapper.writeValueAsString(employee);
		// invoke rest service
		//String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/updateRecord";
		String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/updateRecord";
		
		// set Httpentity object
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		ResponseEntity<String> resp = template.exchange(serviceUrl, HttpMethod.PUT, entity, String.class);

		String result = resp.getBody();
		attrs.addFlashAttribute("result", result);

		return "redirect:showAllEmployee";
	}// end of method
	
	@GetMapping("/delete")
	public String showDeletFormPage(RedirectAttributes attrs,@RequestParam("id") Integer empId, @ModelAttribute("empData") EmployeeBean employee)
			throws Exception {

		// invoke rest method
			//	String serviceurl = "http://lmipl-157.bbrouter:4000/crudApi//delete/{id}";
				String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/delete/{id}";
				
				ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.DELETE, null, String.class, empId);

				// get json body from response
				String result = response.getBody();
		
				attrs.addFlashAttribute("result", result);

				return "redirect:showAllEmployee";
	}// end of method
	
	@GetMapping("/search")
	public String demo() throws Exception{
		return "search_employee";
	}//end of method

	
	
	
@GetMapping("/searchById")
public String demo(@RequestParam("id") Integer empId,ModelMap modelMap) throws Exception{
	System.out.println("BetaController.demo()");
	
	//String serviceurl = "http://lmipl-157.bbrouter:4000/crudApi/showById/{id}";
	String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/showById/{id}";
	
	
	
	ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class, empId);

	// get json body from response
	String jsonBody = response.getBody();
	//System.out.println(jsonBody.toString());
	// convert jsonbody to EmplooyeBean object
	EmployeeBean Tempemployee = mapper.readValue(jsonBody, EmployeeBean.class);
	modelMap.addAttribute("message", "Employee Found:: "+Tempemployee);
	return "Notify";
}//end of method
	
@GetMapping("/getDelete")
public String getDeleteAll() throws Exception{
	return "delete_employee";
}//end of method

@GetMapping("/deleteAll")
public String DeletAll(ModelMap modelMap) throws Exception{
	System.out.println("BetaController.DeletAll()");
	
	//String serviceurl = "http://lmipl-157.bbrouter:4000/crudApi/deleteAll";
	String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/deleteAll";
	
	
	
//	http://192.168.0.163:4000/CrudApi/actuator/info
	
	ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.DELETE, null, String.class );

	// get json body from response
	String jsonBody = response.getBody();
	//System.out.println(jsonBody.toString());
	// convert jsonbody to EmplooyeBean object
	//EmployeeBean Tempemployee = mapper.readValue(jsonBody, EmployeeBean.class);
	modelMap.addAttribute("message", jsonBody);
	return "Notify";
}//end of method


@GetMapping("/updateOrg")
public String updateOrg() throws Exception{
	return "update_Employee_Organisation";
}

@GetMapping("/modifyOrganisation")
public String modifyOrganisation(@RequestParam("id") Integer id ,
		@RequestParam("organisation") String organisation,ModelMap modelMap) throws Exception{
	System.out.println("BetaController.modifyOrganisation()");
	//Integer id=Integer.parseInt(empId);
//	http://lmipl-157.bbrouter:4000/crudApi/modify/18/Wipro
	//String serviceurl = "http://lmipl-157.bbrouter:4000/crudApi/modify/{id}/{organisation}";
	String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/modify/{id}/{organisation";
	
	
	template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.PATCH, null, String.class,id,organisation );

	System.out.println("===========ORGANISATION::"+organisation);
	// get json body from response
	String jsonBody = response.getBody();
	//System.out.println(jsonBody.toString());
	// convert jsonbody to EmplooyeBean object
	//EmployeeBean Tempemployee = mapper.readValue(jsonBody, EmployeeBean.class);
	modelMap.addAttribute("message", jsonBody);
	return "Notify";
}//end of method


}// end of class
