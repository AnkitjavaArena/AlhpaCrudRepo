package com.rcx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "employee_tab")
@SQLDelete(sql="UPDATE employee_tab SET status='inactive' where employeeid=?")
@Where(clause="status<>'inactive'")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeBean implements Serializable {

	@Id
	@Column(name = "employeeid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer EmployeeId;

	@Column(name = "employeename", length = 30)
	@NonNull
	private String employeeName;

	@Column(name = "employeeorganisation", length = 40)
	@NonNull
	private String organisation;

}// end of class
