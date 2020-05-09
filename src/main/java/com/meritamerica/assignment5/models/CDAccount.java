package com.meritamerica.assignment5.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
/*
 * import javax.validation.constraints- NotNull; NotBlank; 
 * Dont need these, set in MeritBank
 */

@Entity
public class CDAccount extends BankAccount {
	
	@Min(1)
	private int term;
	

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

