package com.beta.fClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.beta.entity.EmployeeBean;

@FeignClient("CrudApi")
public interface BetaFeignClient {

	
	@GetMapping("crudApi/showAllEmployees")
	public ResponseEntity<String> fetchAllEmployees();
	
	@PostMapping("crudApi/save")
	public ResponseEntity<String> insertEmpRecords(@RequestBody EmployeeBean employee);

	@GetMapping("crudApi/showById/{id}")
	public ResponseEntity<String> fetchEmpById(@PathVariable("id") Integer id);
	
	@PutMapping("crudApi/updateRecord")
	public ResponseEntity<String> updateRecord(@RequestBody EmployeeBean employee);
	
	@DeleteMapping("crudApi/delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id);

	@DeleteMapping("crudApi/deleteAll")
	public ResponseEntity<String> deleteAllEmployee();
	
	@PatchMapping("crudApi/modify/{id}/{organisation}")
	public ResponseEntity<String> modifyOrganisation(@PathVariable("id") Integer id,
			@PathVariable("organisation") String organisation);	
	
}//end of interface
