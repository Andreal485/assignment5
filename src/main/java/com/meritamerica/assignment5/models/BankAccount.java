package com.meritamerica.assignment5.models;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
/*
 * import javax.validation.constraints NotBlank; NotEmpty; Max
 */

import com.meritamerica.assignment5.MeritBank;
import com.meritamerica.assignment5.exceptions.ExceedsAvailableBalanceException;
import com.meritamerica.assignment5.exceptions.NegativeAmountException;



public class BankAccount {
	
	@Min(0)
	private double balance;
	
	@DecimalMin("0.0")
	@DecimalMax("0.99999")
	private double interestRate;
	
	private long accountNumber;
	private Date accountOpenedOn;
	
	// constructor for new account
	public BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = new Date();
		this.accountNumber = MeritBank.getNextAccountNumber();
		MeritBank.setNextAccountNumber(MeritBank.getNextAccountNumber() + 1); 
		// TODO: add logic to ensure account numbers are not duplicated
	}
	
	// constructor for loaded account
	public BankAccount(double balance, double interestRate, Date accountOpenedOn, long accountNumber){
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
		this.accountNumber = accountNumber;
	}
	
	public BankAccount() {
		this.accountOpenedOn = new Date();
		this.accountNumber = MeritBank.getNextAccountNumber();
		MeritBank.setNextAccountNumber(MeritBank.getNextAccountNumber() + 1); 
		// TODO: add logic to ensure account numbers are not duplicated
	}
	
	public boolean withdraw(double amount) 
				throws ExceedsAvailableBalanceException, NegativeAmountException {
		
		if(amount <= 0) { throw new NegativeAmountException(); }
		if(amount > this.balance) { throw new ExceedsAvailableBalanceException(); }
		
		this.balance -= amount;
		return true;
	}
	
	public boolean deposit(double amount) throws NegativeAmountException {
		if(amount <= 0) { throw new NegativeAmountException(); }
		
		this.balance += amount;
		return true;
	}
	
	public double futureValue(int years) {
		if(years == 0) { return this.balance; }
		return futureValue(years - 1) * (1 + this.interestRate);
	}

	
	public double getBalance() { return balance; }
	public double getInterestRate() { return interestRate; }
	public long getAccountNumber() { return accountNumber; }
	public Date getAccountOpenedOn() { return accountOpenedOn; }

	public void setBalance(double balance) { this.balance = balance; }
	public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
	public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }
	public void setAccountOpenedOn(Date accountOpenedOn) { this.accountOpenedOn = accountOpenedOn; }

	
	

}

