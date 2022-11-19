package com.rcx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcx.entity.EmployeeBean;
import com.rcx.service.AlphaCrudService;

@RestController
@RequestMapping("/crudApi")
public class CrudController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("alphaCrudService")
	private AlphaCrudService service;

	@GetMapping("/showById/{id}")
	public ResponseEntity<?> fetchEmpById(@PathVariable("id") Integer id) {

		logger.debug("Entered::CrudController.showEmpById()");

		logger.info("=====calling service method::========");
		EmployeeBean employee = service.getEmployeeById(id);

		logger.info("Employee Onject found", employee.toString());
		logger.debug("employee record sent as response with status OK");
		logger.debug("Exit::CrudController.showEmpById()");
		return new ResponseEntity<EmployeeBean>(employee, HttpStatus.OK);
	}// end of method

	@GetMapping("/showAllEmployees")
	public ResponseEntity<?> fetchAllEmployees() {
		logger.debug("Entering::CrudController.showAllEmployees()");
		logger.info("calling service.showallEmployees() method");
		Iterable<EmployeeBean> list = service.getAllEmployees();
		logger.info("Employees found");
		logger.debug("employees found, response=ok");
		logger.debug("Exit from method");
		return new ResponseEntity<Iterable<EmployeeBean>>(list, HttpStatus.OK);
	}// end of method

	@PostMapping("/save")
	public ResponseEntity<?> insertEmpRecords(@RequestBody EmployeeBean employee) {

		logger.debug("entering::CrudController.insertEmpRecords()");
		logger.info("Calling service method");
		String responseFromService = service.registerEmployee(employee);
		logger.debug("response sent");
		logger.info("record entered");
		logger.debug("Exit from method");
		return new ResponseEntity<String>(responseFromService, HttpStatus.OK);
	}// end of method(-)

	/*
	 * @PostMapping("/updateEmployee") public ResponseEntity<?>
	 * updateEmpRecords(@RequestBody EmployeeBean employee) { EmployeeBean
	 * serviceResponse = service.searchEmployeeById(employee.getEmployeeId());
	 * 
	 * if (serviceResponse == null) { return new ResponseEntity<String>
	 * ("No matching employeeId found, Updation of Employee failed",
	 * HttpStatus.BAD_REQUEST); } // end of if(-) EmployeeBean responseFromService =
	 * service.insertEmployee(employee); if (responseFromService == null) { return
	 * new ResponseEntity<String>("Updation of Employee Failed",
	 * HttpStatus.BAD_REQUEST); } // end of if(-) return new
	 * ResponseEntity<String>("Employee Successfully updated", HttpStatus.OK); }//
	 * end of method(-)
	 */
	/*
	 * @DeleteMapping("/deleteEmployee") public ResponseEntity<?>
	 * deleteEmpRecord(@RequestParam("employeeId") Integer employeeId) {
	 * EmployeeBean serviceResponse = service.searchEmployeeById(employeeId);
	 * 
	 * if (serviceResponse == null) { return new ResponseEntity<String>
	 * ("No matching employeeId found, Deletion of Employee failed",
	 * HttpStatus.BAD_REQUEST); } // end of if(-)
	 * service.deleteEmployee(employeeId);
	 * 
	 * return new ResponseEntity<String>("Employee Record Deleted", HttpStatus.OK);
	 * }// end of method
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id) {
		System.out.println("CrudController.deleteEmployeeById()");
		logger.debug("CrudController.deleteEmployeeById()");
		logger.info("received response from service");
		String responseFromService = service.deleteEmployeeById(id);
		logger.info("response sent");
		return new ResponseEntity<String>(responseFromService, HttpStatus.OK);
	}// end of method

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllEmployee() {
		System.out.println("CrudController.deleteAllEmployee()");
		logger.debug("CrudController.deleteAllEmployee()");
		logger.info("service method called");
		String responseFromService = service.deleteAllEmployees();
		logger.info("receive response from service");
		logger.debug("Response sent");
		return new ResponseEntity<String>(responseFromService, HttpStatus.OK);
	}// end of method

	@PutMapping("/updateRecord")
	public ResponseEntity<String> updateActorRecord(@RequestBody EmployeeBean employee) {
		System.out.println("CrudController.updateActorRecord()");
		logger.debug("CrudController.updateActorRecord()");
		logger.info("servivce method called");
		String msg = service.updateEmployeeRecord(employee);
		logger.info("Received response from service");
		logger.debug("Response sent ");
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}// end of method

	@PatchMapping("/modify/{id}/{organisation}")
	public ResponseEntity<String> modifyOrganisation(@PathVariable("id") Integer id,
			@PathVariable("organisation") String organisation) {
		System.out.println("CrudController.modifyOrganisation()");
		logger.debug("CrudController.modifyOrganisation()");
		logger.info("Service method called");
		String msg = service.updateEmployeesOrganisation(id, organisation);
		logger.debug("Response sent");
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}// end of method
	
	
}// end of class
