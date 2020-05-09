package com.meritamerica.assignment5.models;

import java.util.Date;

import com.meritamerica.assignment5.models.BankAccount;

public class SavingsAccount extends BankAccount {
	static final double DEFAULT_INTEREST_RATE = .01;
	
	
	public SavingsAccount() { 
		super();
		super.setInterestRate(DEFAULT_INTEREST_RATE);
	}

}
