package com.meritamerica.assignment5.models;

import java.util.Date;

import com.meritamerica.assignment5.models.BankAccount;

public class SavingsAccount extends BankAccount {
	static final double DEFAULT_INTEREST_RATE = .01;
	
	// new account
	public SavingsAccount (double openingBalance) {
		super(openingBalance, DEFAULT_INTEREST_RATE);
	}
	
	// loaded from account object 
	public SavingsAccount (BankAccount bankAccount) {
		super(bankAccount.getBalance(), bankAccount.getInterestRate(), 
				bankAccount.getAccountOpenedOn(), bankAccount.getAccountNumber());
	}
	
	// loaded from values
	public SavingsAccount(double balance, double interestRate, Date openedOn, long accountNumber) {
		super(balance, interestRate, openedOn, accountNumber);
	}
	
	public SavingsAccount() { 
		super();
		super.setInterestRate(DEFAULT_INTEREST_RATE);
	}

}
