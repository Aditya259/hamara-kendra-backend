package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solar.Model.BookingDetails;
import com.solar.Model.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer>{

}
