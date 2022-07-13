package com.solar.contoller;

import org.springframework.beans.factory.annotation.Autowired;

import com.solar.Model.SubMenuDescription;
import com.solar.repository.SubMenuDescriptionRepository;

public class Insert {
	
	@Autowired
	static SubMenuDescriptionRepository subMenuDescriptionRepository;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubMenuDescription s = new SubMenuDescription();
		s.setId(1);
		s.setFirstDesc("For 0-5 Year below age |\r\n"
				+ "<br>|\r\n"
				+ "<b>Required document</b>|\r\n"
				+ "<ul>|\r\n"
				+ "<li>1. Birth Certificate</li>|\r\n"
				+ "<li>1. Gardian Addhar Card (Original)</li>|\r\n"
				+ "</ul>|");
		s.setSubServicesId(1);
		subMenuDescriptionRepository.save(s);
	}

}
