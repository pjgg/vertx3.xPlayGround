package org.pablo.dto;

import java.io.Serializable;

public class Status implements Serializable{

	private static final long serialVersionUID = 1L;

	private Boolean value;
	
	public Status(){}
	
	public Status(Boolean value){
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}
	
}
