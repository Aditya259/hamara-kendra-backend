package com.solar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.solar.Model.ThirdLevelSubMenu;

@Repository
public interface ThirdLevelSubMenuRepo extends JpaRepository<ThirdLevelSubMenu, Integer>{
	
	ThirdLevelSubMenu findBysubMenuServicesId(int id);

}
