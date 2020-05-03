package com.meritamerica.assignment5.models;

import java.util.Date;

import com.meritamerica.assignment5.models.BankAccount;

public class CheckingAccount extends BankAccount {

	static final double DEFAULT_INTEREST_RATE = .0001;
	
	// new account
	public CheckingAccount (double openingBalance) {
		super(openingBalance, DEFAULT_INTEREST_RATE);
	}
	
	// loaded from account object 
	public CheckingAccount (BankAccount bankAccount) {
		super(bankAccount.getBalance(), bankAccount.getInterestRate(), 
				bankAccount.getAccountOpenedOn(), bankAccount.getAccountNumber());
	}
	
	// loaded from values
	public CheckingAccount(double balance, double interestRate, Date openedOn, long accountNumber) {
		super(balance, interestRate, openedOn, accountNumber);
	}
	
	public CheckingAccount() {
		super(); 
		super.setInterestRate(DEFAULT_INTEREST_RATE);
	}
}

