package com.beta.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beta.entity.EmployeeBean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BetaController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/")
	public String showHomePage() {
		return "home"; // return logical view name to viewreslover
	}// end of method

	@GetMapping("/showAllEmployee")
	public String showAllEmployee(Map<String, Object> map) throws Exception {

		String serviceUrl = "http://lmipl-157.bbrouter:4000/crudApi/showAllEmployees";

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
	public String registerEmployee(RedirectAttributes attrs, @ModelAttribute("empData") EmployeeBean employee)
			throws Exception {
		System.out.println("BetaController.registerTourist()");
		// converting received object to JSON data using jackson api
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(employee);
		// invoke Spring rest service

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

}// end of class
