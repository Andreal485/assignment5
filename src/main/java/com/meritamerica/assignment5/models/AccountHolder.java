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
	public int noCheckingAcct; 
	public int noSavingsAcct; 
	public int noCDAcct; 
	public double checkingAcctBalance; 
	public double savingsAcctBalance; 
	public double cdAcctBalance; 
	public double combinedBalance; 
	
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
		this.checkingAccountNo = 0;
		this.checkingAccounts = new CheckingAccount[100];
		this.noCheckingAcct = checkingAccounts.length; 
		this.checkingAcctBalance = checkingAcctBalance; 

		this.savingsAccountNo = 0;
		this.savingsAccounts = new SavingsAccount[100];
		this.noSavingsAcct = savingsAccounts.length; 
		this.savingsAcctBalance = savingsAcctBalance; 

		this.cdAccountNo= 0;
		this.cdAccounts = new CDAccount[100];
		this.noCDAcct = cdAccounts.length; 
		this.cdAcctBalance = cdAcctBalance; 
		
		this.combinedBalance = checkingAcctBalance + savingsAcctBalance + cdAcctBalance; 

		//cleaningupcode
		//this.noCheckingAcct = checkingAccounts.length; 
		//this.noSavingsAcct = savingsAccounts.length; 
		//this.noCDAcct = cdAccounts.length; 
		
		
	}
	
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		checkingAccounts [checkingAccountNo] = checkingAccount; 
		checkingAccountNo++; 
		return checkingAccount; 
	}
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		savingsAccounts [savingsAccountNo] = savingsAccount; 
		savingsAccountNo++; 
		return savingsAccount; 
	}
	public CDAccount addCDAccount(CDAccount cdAccount) {
		cdAccounts [cdAccountNo] = cdAccount; 
		cdAccountNo++; 
		return cdAccount; 
	}
	
	public int getNoCheckingAcct() {
		return noCheckingAcct;
	}

	public void setNoCheckingAcct(int noCheckingAcct) {
		this.noCheckingAcct = noCheckingAcct;
	}

	public int getNoSavingsAcct() {
		return noSavingsAcct;
	}

	public void setNoSavingsAcct(int noSavingsAcct) {
		this.noSavingsAcct = noSavingsAcct;
	}

	public int getNoCDAcct() {
		return noCDAcct;
	}

	public void setNoCDAcct(int noCDAcct) {
		this.noCDAcct = noCDAcct;
	}

	public double getCheckingAcctBalance() {
		return checkingAcctBalance;
	}

	public void setCheckingAcctBalance(double checkingAcctBalance) {
		this.checkingAcctBalance = checkingAcctBalance;
	}

	public double getSavingsAcctBalance() {
		return savingsAcctBalance;
	}

	public void setSavingsAcctBalance(double savingsAcctBalance) {
		this.savingsAcctBalance = savingsAcctBalance;
	}

	public double getCdAcctBalance() {
		return cdAcctBalance;
	}

	public void setCdAcctBalance(double cdAcctBalance) {
		this.cdAcctBalance = cdAcctBalance;
	}

	public double getCombinedBalance() {
		return combinedBalance;
	}

	public void setCombinedBalance(double combinedBalance) {
		this.combinedBalance = combinedBalance;
	}

	public CheckingAccount[] getCheckingAccounts() {
		System.out.println(checkingAccounts);
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
