package com.project.UserService.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class User {
	
	@Id
	private String email;
	private String userName;
	private String password;
	
	public User() {
		super();
	}

	public User(String email, String userName, String password) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
	

}
