package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solar.Model.Services;
import com.solar.Model.SubMenuServices;

@Repository
public interface SubMenuServicesRepository extends JpaRepository<SubMenuServices, Integer>{

}
