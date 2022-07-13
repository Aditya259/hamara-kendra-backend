package com.solar.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Admins {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String user;
	private String pass;
	private String role;
	private String department;
	private Date createAt;
	private String mobileNo;
	private String liveOrLastLocation;

	@Transient
	private String otp;

	@Transient
	private String status;

	public Admins() {
		super();
	}

	public Admins(int id, String name, String user, String pass, String role, String department, Date createAt,
			String status, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.pass = pass;
		this.role = role;
		this.mobileNo = mobileNo;
		this.department = department;
		this.createAt = createAt;
		this.status = status;
	}

	public String getLiveOrLastLocation() {
		return liveOrLastLocation;
	}

	public void setLiveOrLastLocation(String liveOrLastLocation) {
		this.liveOrLastLocation = liveOrLastLocation;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admins [id=" + id + ", name=" + name + ", user=" + user + ", pass=" + pass + ", role=" + role
				+ ", department=" + department + ", createAt=" + createAt + ", mobileNo=" + mobileNo
				+ ", liveOrLastLocation=" + liveOrLastLocation + ", otp=" + otp + ", status=" + status + "]";
	}

	

}
