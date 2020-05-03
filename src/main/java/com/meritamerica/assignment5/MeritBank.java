package com.meritamerica.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.meritamerica.assignment5.models.BankAccount;
import com.meritamerica.assignment5.exceptions.NotFoundException;

public class MeritBank {
	private static List<AccountHolder> accountHolders = new ArrayList<>();
	private static List<CDOffering> cdOfferings = new ArrayList<>();
	private static long nextAccountNumber = 1;
	private static long nextAccountHolderNumber = 1;
	
	
	
	public static void addAccountHolder(AccountHolder ah) {
		accountHolders.add(ah);
		setNextAccountHolderNumber(getNextAccountHolderNumber() + 1);
	}
	
	public static List<AccountHolder> getAccountHolders() { return accountHolders; }
	
	public static List<CDOffering> getCDOfferings() throws NotFoundException {
		if(cdOfferings.size() == 0) { throw new NotFoundException("No CDOfferings found "); }
		return cdOfferings; 
	} 
	
	// find bank account by account number
	public static BankAccount getBankAccount(long id) throws NotFoundException {
		for(AccountHolder ah : accountHolders) {
			for(BankAccount b : ah.getCheckingAccounts() ) {
				if(b.getAccountNumber() == id) { return b; }
			}
			for(BankAccount b : ah.getSavingsAccounts() ) {
				if(b.getAccountNumber() == id) { return b; }
			}
			for(BankAccount b : ah.getCDAccounts() ) {
				if(b.getAccountNumber() == id) { return b; }
			}
		}
		throw new NotFoundException("Account with id " + id + " not found ");
	}
	
	//find account holder by holder's id
	public static AccountHolder getAccountHolderByID(long id) throws NotFoundException {
		for(AccountHolder ah : accountHolders) {
			if(ah.getID() == id) { return ah; }
		}
		throw new NotFoundException("Account Holder with id " + id + " not found ");
	}
	
	
	static CDOffering getBestCDOffering(double depositAmount) {
		if(cdOfferings.size() == 0) { return null; }
		
		double bestRate = 0;
		CDOffering best = null;
		
		for(CDOffering cdo : cdOfferings) {
			if(cdo.getInterestRate() > bestRate) {
				best = cdo;
				bestRate = cdo.getInterestRate();
			}
		}
		
		return best;
	}
	
	static CDOffering getSecondBestCDOffering(double depositAmount) {
		if(cdOfferings.size() <= 1) { return null; }
		
		CDOffering best = getBestCDOffering(depositAmount);
		CDOffering secondBest = null;
		double secondBestRate = 0;
		
		for(CDOffering cdo : cdOfferings) {
			if(cdo == best) { continue; }
			if(cdo.getInterestRate() > secondBestRate) {
				secondBest = cdo;
				secondBestRate = cdo.getInterestRate();
			}
			
		}
		
		return secondBest;
	}
	
	public static void clearCDOfferings() {
		cdOfferings.clear();
	}
	
	// add CDOffering types by list
	public static void setCDOfferins(List<CDOffering> offerings) {
		for(CDOffering cdo : offerings) {
			cdOfferings.add(cdo);
		}
	}
	// add CDOffering types by array
	public static void setCDOfferings(CDOffering[] offerings) {
		for(int i=0; i<offerings.length; i++) {
			cdOfferings.add(offerings[i]);
		}
	}
	//add CDOffering by object
	public static void addCDOffering(CDOffering o) {
		cdOfferings.add(o);
	}
	
	public static long getNextAccountNumber() { return nextAccountNumber; }
	
	public static void setNextAccountNumber(long accountNumber) { nextAccountNumber = accountNumber; }
	
	public static long getNextAccountHolderNumber() { return nextAccountHolderNumber; }
	
	public static void setNextAccountHolderNumber(long accountNumber) { nextAccountHolderNumber = accountNumber; }
	
	
	static double totalBalances() {
		double sum = 0;
		
		for(AccountHolder ah : accountHolders) {
			for(BankAccount b : ah.getCheckingAccounts()) {
				sum += b.getBalance();
			}
			for(BankAccount b : ah.getSavingsAccounts()) {
				sum += b.getBalance();
			}
			for(BankAccount b : ah.getCDAccounts()) {
				sum += b.getBalance();
			}
			
		}
			
		return sum;
	}
	
	static void sortAccountHolders() {
		Collections.sort(accountHolders);
	}
	
	
}

