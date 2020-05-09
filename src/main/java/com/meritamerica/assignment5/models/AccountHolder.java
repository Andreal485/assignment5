package com.meritamerica.assignment5.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.meritamerica.assignment5.exceptions.ExceedsCombinedBalanceLimitException;

@Entity 
@Table (name = "accountholders")
public class AccountHolder implements Comparable <AccountHolder> {
	
	@NotBlank(message = "First Name is required")
	private String firstName;
	
	private String middleName;
	
	@NotBlank(message = "Last Name is required")
	private String lastName;
	
	@Size(min=9, max=11)
	@NotBlank(message = "SSN is required")
	private String ssn;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	private AccountHolderContactDetails accountHolderContactDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<BankAccount> checkingAccounts;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<BankAccount> savingsAccounts;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<BankAccount> cdAccounts;

	private int NumberOfCheckingAccounts;
	private int NumberOfSavingsAccounts;
	private int NumberOfCDAccounts;
	
	
	//new account holder
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.checkingAccounts = new ArrayList <>();
		this.savingsAccounts = new ArrayList <>();
		this.cdAccounts = new ArrayList <>();
	 
	}
	
	public AccountHolder() {
		this.checkingAccounts = new ArrayList <>();
		this.savingsAccounts = new ArrayList <>();
		this.cdAccounts = new ArrayList <>();
	}
	
	
	
	public boolean addCheckingAccount(CheckingAccount b) throws ExceedsCombinedBalanceLimitException {
		if(b == null) { return false; }
		if(getCheckingBalance() + getSavingsBalance() + b.getBalance() >= 250000 ) {
			System.out.println(b.getBalance());
			System.out.println(getCheckingBalance() + getSavingsBalance() + b.getBalance());
			throw new ExceedsCombinedBalanceLimitException();
		}
		checkingAccounts.add(b);
		return true;
	}
	
	public boolean addSavingsAccount(SavingsAccount b) throws ExceedsCombinedBalanceLimitException {
		if(b == null) { return false; }
		if(getCheckingBalance() + getSavingsBalance() + b.getBalance() >= 250000 ) {
			throw new ExceedsCombinedBalanceLimitException();
		}
		savingsAccounts.add(b);
		return true;
	}
	
	public boolean addCDAccount(CDAccount b) {
		if(b == null) { return false; }
		cdAccounts.add(b);
		return true;
	}
	
	
	
	
	public double getCheckingBalance() {
		double sum = 0;
		for(BankAccount b : checkingAccounts) {
			sum += b.getBalance();
		}
		return sum;
	}
	public double getSavingsBalance() {
		double sum = 0;
		for(BankAccount b : savingsAccounts) {
			sum += b.getBalance();
		}
		return sum;
	}
	public double getCDBalance() {
		double sum = 0;
		for(BankAccount b : cdAccounts) {
			sum += b.getBalance();
		}
		return sum;
	}
	public double getCombinedBalance() {
		double sum = 0;
		sum += getCheckingBalance();
		sum += getSavingsBalance();
		sum += getCDBalance();
		return sum;
	}
	
	
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String s) { this.firstName = s; }

	public String getMiddleName() { return middleName; }
	public void setMiddleName(String s) { this.middleName = s; }

	public String getLastName() { return lastName; }
	public void setLastName(String s) { this.lastName = s; }

	public String getSSN() { return ssn; }
	public void setSsnName(String s) { this.ssn = s; }

	public List<BankAccount> getCheckingAccounts() { return checkingAccounts; }

	public List<BankAccount> getSavingsAccounts() { return savingsAccounts; }

	public List<BankAccount> getCDAccounts() { return cdAccounts; }
	
	public long getID() { return this.id; }

	
	@Override
	public int compareTo(AccountHolder other) {
		int mySum = (int) getCombinedBalance();
		int otherSum = (int) other.getCombinedBalance();
		return mySum - otherSum;
	}

	public int getNumberOfCDAccounts() {
		return NumberOfCDAccounts;
	}

	public void setNumberOfCDAccounts(int numberOfCDAccounts) {
		NumberOfCDAccounts = numberOfCDAccounts;
	}

	public int getNumberOfSavingsAccounts() {
		return NumberOfSavingsAccounts;
	}

	public void setNumberOfSavingsAccounts(int numberOfSavingsAccounts) {
		NumberOfSavingsAccounts = numberOfSavingsAccounts;
	}

	public int getNumberOfCheckingAccounts() {
		return NumberOfCheckingAccounts;
	}

	public void setNumberOfCheckingAccounts(int numberOfCheckingAccounts) {
		NumberOfCheckingAccounts = numberOfCheckingAccounts;
	}
	
	
	
	
	
	
	
	
	
}


