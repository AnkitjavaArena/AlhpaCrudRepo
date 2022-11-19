package com.rcx.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcx.entity.EmployeeBean;
import com.rcx.exceptions.EmployeeNotFoundException;
import com.rcx.repository.IAlphaCrudRepo;

@Service("alphaCrudService")
public class AlphaCrudService {

	@Autowired
	private IAlphaCrudRepo alphaCrudRepo;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	public EmployeeBean getEmployeeById(Integer employeeId) {
		// Optional<EmployeeBean> employee = alphaCrudRepo.findById(employeeId);
		// if (employee.isEmpty())
		// return null;
		// return employee.get();
		System.out.println("AlphaCrudService.getEmployeeById()");
		logger.debug("AlphaCrudService.getEmployeeById()");
		return alphaCrudRepo.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("invalid  actor id"));
	}// end of method

	public List<EmployeeBean> getAllEmployees() {
		// List<EmployeeBean> employeesList = alphaCrudRepo.findAll();
		// return employeesList;
		// using stream api to fetch and sore the records
		System.out.println("AlphaCrudService.getAllEmployees()");
		logger.debug("AlphaCrudService.getAllEmployees()");
		Iterable<EmployeeBean> it = alphaCrudRepo.findAll();
		List<EmployeeBean> list1 = StreamSupport.stream(it.spliterator(), false)
				.sorted((t1, t2) -> t1.getEmployeeName().compareTo(t2.getEmployeeName())).collect(Collectors.toList());
		return list1;
	}// end of method

	public String registerEmployee(EmployeeBean employee) {
		System.out.println("AlphaCrudService.registerEmployee()");
		logger.debug("AlphaCrudService.registerEmployee()");
		EmployeeBean employeeResponse = alphaCrudRepo.save(employee);

		return "Employee is registered with  id value::" + employeeResponse.getEmployeeId();
	}// end of method

	public String deleteEmployeeById(Integer employeeId) {
		System.out.println("AlphaCrudService.deleteEmployeeById()");
		logger.debug("AlphaCrudService.deleteEmployeeById()");
		Optional<EmployeeBean> opt = alphaCrudRepo.findById(employeeId);
		if (opt.isPresent()) {
			alphaCrudRepo.deleteById(employeeId);
			return "Employee information is deleted";
		} else {
			logger.error("Exception raised");
			throw new EmployeeNotFoundException("EmployeeNotFound");
		}
	}// end of method

	public String deleteAllEmployees() {
		System.out.println("AlphaCrudService.deleteAllEmployees()");
		logger.debug("AlphaCrudService.deleteAllEmployees()");
		alphaCrudRepo.deleteAll();
		return "All Records Deleted";
	}// end of method

	public String updateEmployeesOrganisation(Integer id, String organisation) {
		System.out.println("AlphaCrudService.updateEmployeesOrganisation()");
		logger.debug("AlphaCrudService.updateEmployeesOrganisation()");
		Optional<EmployeeBean> optional = alphaCrudRepo.findById(id);

		if (optional.isPresent()) {
			EmployeeBean employee = optional.get();
			employee.setOrganisation(organisation);
			alphaCrudRepo.save(employee);
			return "Employee's Organisation is updated";
		} // end of if(-)
		else {
			logger.error("Exception raised");
			throw new IllegalArgumentException("Employee Not found");
		} // end of else case

	}// end of method

	public String updateEmployeeRecord(EmployeeBean employee) {
		System.out.println("AlphaCrudService.updateEmployeeRecord()");
		logger.debug("AlphaCrudService.updateEmployeeRecord()");
		Optional<EmployeeBean> optional = alphaCrudRepo.findById(employee.getEmployeeId());
		if (optional.isEmpty())
			throw new EmployeeNotFoundException("EmployeeNotFound");
		// updating preexisting record
		alphaCrudRepo.save(employee);
		return "Employee record updated";
	}// end of method

}// end of class
