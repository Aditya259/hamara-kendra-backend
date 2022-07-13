package com.solar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solar.Model.Admins;

@Repository
@Transactional
public interface AdminRepo  extends JpaRepository<Admins, Integer>{

	Admins findByuser(String user);
	
	List<Admins> findAllByOrderByIdDesc();
	
	Admins findBymobileNo(String mobileNo);
}
