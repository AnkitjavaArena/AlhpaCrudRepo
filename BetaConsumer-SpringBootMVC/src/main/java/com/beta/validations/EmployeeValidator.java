package com.beta.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.beta.entity.EmployeeBean;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("EmployeeValidator.supports()");
		// we are checking whether we are passing correct modl data
		return clazz.isAssignableFrom(EmployeeBean.class);
	}// end of method

	// if above method returns true then this method will be executed automatically
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		// type casting
		EmployeeBean emp = (EmployeeBean) target;
		// validation logics
		if (emp.getEmployeeName() == null || emp.getEmployeeName().length() == 0 || emp.getEmployeeName().equals("")) {
			errors.rejectValue("employeeName", "employeeName.required");
		} // end of if case

		else if (emp.getEmployeeName().length() > 10)
			errors.rejectValue("employeeName", "employeeName.maxlength");

		if (emp.getOrganisation() == null || emp.getOrganisation().length() == 0 || emp.getOrganisation().equals("")) {
			errors.rejectValue("organisation", "organisation.required");
		} // end of if case

		else if (emp.getOrganisation().length() < 3)
			errors.rejectValue("organisation", "organisation.maxlength");

	}// end of method

}// end of class
