package com.meritamerica.assignment5.models;

import java.util.Date;

import javax.validation.constraints.Min;
/*
 * import javax.validation.constraints- NotNull; NotBlank; 
 * Dont need these, set in MeritBank
 */


public class CDAccount extends BankAccount {
	
	@Min(1)
	private int term;
	
	// new account from values
	public CDAccount (double openingBalance, double interestRate, int term) {
		super(openingBalance, interestRate);
		this.term = term;
	}
	
	
	// loaded from values
	public CDAccount(double balance, double interestRate, Date openedOn, long accountNumber, int term) {
		super(balance, interestRate, openedOn, accountNumber);
		this.term = term;
	}
	
	public CDAccount() { super(); }
	
	
	@Override
	public boolean withdraw(double amount) {
		return false;
	}
	
	@Override
	public boolean deposit(double amount) {
		return false;
	}
	
	
	
	public int getTerm() { return this.term; }
	public void setTerm(int n) { this.term = n; }

}

