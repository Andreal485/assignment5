package com.meritamerica.assignment5.models;

import org.hibernate.validator.constraints.NotBlank;
//import jarvax.validation.constraints.NotBlank; 

public class AccountHolder {
	static int nextId= 0; 
	
	int id; 
	
	@NotBlank(message = "First name is Mandatory")
	String firstName; 
	
	String middleName;
	
	@NotBlank(message = "Last name is Mandatory")
	String lastName;
	
	@NotBlank(message = "SSN is Mandatory")
	String ssn; //easier if string. JSON will convert if int inputed instead. not sure for VV

	public AccountHolder() {
		this.id = nextId++;
		
		this.firstName = ""; 
		this.middleName = ""; 
		this.lastName = ""; 
		this.ssn = ""; 
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		AccountHolder.nextId = nextId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
}
