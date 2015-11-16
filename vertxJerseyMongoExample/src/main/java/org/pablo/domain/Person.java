package org.pablo.domain;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
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
