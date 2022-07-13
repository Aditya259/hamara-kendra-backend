package com.solar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solar.Model.Admins;
import com.solar.repository.AdminRepo;

@Service
public class AdminServices  {

	@Autowired
	AdminRepo adminRepo;
	
	public Admins getAdmin(int id) {
		Optional<Admins> opt = adminRepo.findById(id);
		Admins admins = opt.get();
		return admins;
	}

	public void addAdmin(Admins admins) {
		adminRepo.save(admins);
	}
}
