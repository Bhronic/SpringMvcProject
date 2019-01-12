package com.demo.beans;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=false)
public class User {
	private int user_id,roles_id;
	private String name;
	private String email;
	private String password;
	private String dob;
	private String gender;
	private String contact_no;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRoles_id() {
		return roles_id;
	}
	public void setRoles_id(int roles_id) {
		this.roles_id = roles_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", roles_id=" + roles_id + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", contact_no=" + contact_no + "]";
	}
	
	

}
