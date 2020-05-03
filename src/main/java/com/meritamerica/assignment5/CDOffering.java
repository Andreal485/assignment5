package com.meritamerica.assignment5;

public class CDOffering {
	private int term;
	private double interestRate;
	
	public CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}
	
	public CDOffering() { }
	
	public int getTerm() { return this.term; }
	public void setTerm(int n) { this.term = n; }
	
	public double getInterestRate() { return this.interestRate; }
	public void setInterestRate(double n) { this.interestRate = n; }


}
