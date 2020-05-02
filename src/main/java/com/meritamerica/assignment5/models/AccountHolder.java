package com.meritamerica.assignment5.models;

import javax.validation.constraints.NotBlank;

public class AccountHolder {
	/**
	 * Part 1
	 */
	static int nextId= 0; 
	int id; 
	
	
	@NotBlank(message = "First name is Mandatory")
	String firstName; 
	
	String middleName;
	
	@NotBlank(message = "Last name is Mandatory")
	String lastName;
	
	@NotBlank(message = "SSN is Mandatory")
	String ssn; //easier if string. JSON will convert if int inputed instead. not sure for VV
	/**
	 * Part 2
	 */
	public CheckingAccount [] checkingAccounts; 
	public int checkingAccountNo = 0; 
	public SavingsAccount[] savingsAccounts; 
	public int savingsAccountNo = 0; 
	public CDAccount [] cdAccounts;
	public int cdAccountNo = 0; 
	
	/**
	 *  part 1
	 */
	public AccountHolder() {
		this.id = ++nextId;
		
		this.firstName = ""; 
		this.middleName = ""; 
		this.lastName = ""; 
		this.ssn = ""; 
	/**
	 * Part 2
	 */
		this.checkingAccountNo++;
		this.checkingAccounts = new CheckingAccount[1];
		this.savingsAccountNo++;
		this.savingsAccounts = new SavingsAccount[1];
		this.cdAccountNo++;
		this.cdAccounts = new CDAccount[1];
	}

	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
	}

	public void setCheckingAccounts(CheckingAccount[] checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}

	public int getCheckingAccountNo() {
		return checkingAccountNo;
	}

	public void setCheckingAccountNo(int checkingAccountNo) {
		this.checkingAccountNo = checkingAccountNo;
	}

	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(SavingsAccount[] savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}

	public int getSavingsAccountNo() {
		return savingsAccountNo;
	}

	public void setSavingsAccountNo(int savingsAccountNo) {
		this.savingsAccountNo = savingsAccountNo;
	}

	public CDAccount[] getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(CDAccount[] cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

	public int getCdAccountNo() {
		return cdAccountNo;
	}

	public void setCdAccountNo(int cdAccountNo) {
		this.cdAccountNo = cdAccountNo;
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
