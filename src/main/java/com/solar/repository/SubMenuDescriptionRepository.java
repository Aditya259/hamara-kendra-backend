package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solar.Model.Services;
import com.solar.Model.SubMenuDescription;

@Repository
public interface SubMenuDescriptionRepository extends JpaRepository<SubMenuDescription, Integer>{

}
