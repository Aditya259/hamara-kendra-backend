package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solar.Model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer>{

}
