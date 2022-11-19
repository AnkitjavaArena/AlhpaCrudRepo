package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist,Integer>{

}//end of interface