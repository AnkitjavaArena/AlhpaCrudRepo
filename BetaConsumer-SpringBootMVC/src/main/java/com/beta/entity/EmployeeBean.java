package com.beta.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeBean implements Serializable {

	private Integer employeeId;

	@NonNull
	private String employeeName;

	@NonNull
	private String organisation;

}// end of class
