package com.uwc.spring.UWC.Model;

import java.util.Date;

public class User {
	private String id_user;
	private String name;
	private String position_user;
	private Date dob;
	private String username;
	private String password;
	
	
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition_user() {
		return position_user;
	}
	public void setPosition_user(String position_user) {
		this.position_user = position_user;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
