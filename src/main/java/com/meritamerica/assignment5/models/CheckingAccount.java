package com.meritamerica.assignment5.models;

import java.util.Date;

import com.meritamerica.assignment5.models.BankAccount;

public class CheckingAccount extends BankAccount {

	static final double DEFAULT_INTEREST_RATE = .0001;
	
	
	public CheckingAccount() {
		super(); 
		super.setInterestRate(DEFAULT_INTEREST_RATE);
	}
}

