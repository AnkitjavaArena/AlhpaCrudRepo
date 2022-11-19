package com.rcx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcx.entity.EmployeeBean;

public interface IAlphaCrudRepo extends JpaRepository<EmployeeBean, Integer> {

}// end of interface
