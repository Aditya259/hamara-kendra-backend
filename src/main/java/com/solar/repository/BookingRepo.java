package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solar.Model.Admins;
import com.solar.Model.BookingDetails;

public interface BookingRepo extends JpaRepository<BookingDetails, Integer>{

}
