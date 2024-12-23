package com.macfoods.dto;

public class User {

	 private int userId;
	 private String userName;
	 private String password;
	 private String email;
	 private String mobile;
	 private String address;
	 private String role;
	 
	public User(int userId, String userName, String password, String mobile,String email, String address, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.mobile=mobile;
	}
	
	public User(String userName, String password,String mobile, String email, String address, String role) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.mobile=mobile;
	}
	
	public User(String userName, String password,String mobile, String email) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		
		this.mobile=mobile;
	}

	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		
		return userId+" "+userName+" "+mobile+" "+password+" "+email+" "+address+" "+role;
	}

	 
	 
	 
}
