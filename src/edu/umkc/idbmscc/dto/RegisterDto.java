package edu.umkc.idbmscc.dto;

import java.io.Serializable;

public class RegisterDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5504764377833218864L;

	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String mobilenumber;
	private String zipcode;
	private String category;
	
	
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "RegisterDto [email=" + email + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobilenumber=" + mobilenumber + ", zipcode=" + zipcode
				+ ", category=" + category + "]";
	}
	
}
