package org.pablo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.NotBlank;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9_-]{3,15}$", message="must be an alphaNumeric value size 3-15")
	private String firstname;
	
	private String lastname;
	
	public String getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
