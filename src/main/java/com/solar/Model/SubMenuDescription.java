package com.solar.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubMenuDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstDesc;

	private String secondDesc;

	private String thirdDesc;

	private String fourthDesc;

	private String fifthDesc;

	private String sixthDesc;

	private String seventhDesc;

	private int subServicesId;

	private int subServicesThirdlevelId;
	
	private int menuId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstDesc() {
		return firstDesc;
	}

	public void setFirstDesc(String firstDesc) {
		this.firstDesc = firstDesc;
	}

	public String getSecondDesc() {
		return secondDesc;
	}

	public void setSecondDesc(String secondDesc) {
		this.secondDesc = secondDesc;
	}

	public String getThirdDesc() {
		return thirdDesc;
	}

	public void setThirdDesc(String thirdDesc) {
		this.thirdDesc = thirdDesc;
	}

	public String getFourthDesc() {
		return fourthDesc;
	}

	public void setFourthDesc(String fourthDesc) {
		this.fourthDesc = fourthDesc;
	}

	public String getFifthDesc() {
		return fifthDesc;
	}

	public void setFifthDesc(String fifthDesc) {
		this.fifthDesc = fifthDesc;
	}

	public String getSixthDesc() {
		return sixthDesc;
	}

	public void setSixthDesc(String sixthDesc) {
		this.sixthDesc = sixthDesc;
	}

	public String getSeventhDesc() {
		return seventhDesc;
	}

	public void setSeventhDesc(String seventhDesc) {
		this.seventhDesc = seventhDesc;
	}

	public int getSubServicesId() {
		return subServicesId;
	}

	public void setSubServicesId(int subServicesId) {
		this.subServicesId = subServicesId;
	}

	public int getSubServicesThirdlevelId() {
		return subServicesThirdlevelId;
	}

	public void setSubServicesThirdlevelId(int subServicesThirdlevelId) {
		this.subServicesThirdlevelId = subServicesThirdlevelId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "SubMenuDescription [id=" + id + ", firstDesc=" + firstDesc + ", secondDesc=" + secondDesc
				+ ", thirdDesc=" + thirdDesc + ", fourthDesc=" + fourthDesc + ", fifthDesc=" + fifthDesc
				+ ", sixthDesc=" + sixthDesc + ", seventhDesc=" + seventhDesc + ", subServicesId=" + subServicesId
				+ ", subServicesThirdlevelId=" + subServicesThirdlevelId + ", menuId=" + menuId + "]";
	}

	
}
