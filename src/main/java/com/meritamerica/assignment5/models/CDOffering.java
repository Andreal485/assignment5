package com.meritamerica.assignment5.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="cd_offerings")
public class CDOffering {
	
	@NotBlank 
	@Min(1)
	private int term;
	
	@NotBlank
	@DecimalMin("0.0")
	@DecimalMax("0.99999")
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
