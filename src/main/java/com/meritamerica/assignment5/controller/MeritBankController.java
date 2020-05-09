package com.meritamerica.assignment5.controller; 

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.CDOffering;
import com.meritamerica.assignment5.MeritBank;
import com.meritamerica.assignment5.models.BankAccount;
import com.meritamerica.assignment5.models.CDAccount;
import com.meritamerica.assignment5.models.SavingsAccount;
import com.meritamerica.assignment5.repos.*;
import com.meritamerica.assignment5.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.exceptions.NotFoundException;
import com.meritamerica.assignment5.AccountHolder;
import com.meritamerica.assignment5.models.CheckingAccount;

@RestController
public class MeritBankController {
	List<String> strings = new ArrayList<String>(); 
	
	@Autowired
	private AccountHolderContactDetailsRepository accountHolderContactRepo;
	@Autowired
	private AccountHolderRepository accountHolderRepo;
	@Autowired
	private CDAccountRepository cdAccountRepo;
	@Autowired
	private CDOfferingRepository cdOfferingRepo;
	@Autowired
	private CheckingAccountRepository checkingAccountRepo;
	@Autowired
	private SavingsAccountRepository savingsAccountRepo;
	
	
	//List<AccountHolder> ac = new ArrayList<AccountHolder>(); 
	
	//List<CheckingAccount> ca = new ArrayList<CheckingAccount>(); 

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "Welcome to MeritBank"; 
	}
	
	@GetMapping(value="/strings") //@RequestMapping(value = "/strings", method = RequestMethod.GET)
	public List<String> getStrings() {
		return strings; 
	}
	
	@PostMapping(value = "/strings")
	//http://localhost:8080/strings POST, insert, then GET, you should see all inputs from prior
	public String addString(@RequestBody String string) {
		//String string = "test"; 
		strings.add(string); 
		return string; 
		
	} 
	
	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccoungHolder(){
		return MeritBank.getAccountHolders(); 
	}
	
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		MeritBank.addAccountHolder(accountHolder); 
		return accountHolder; 
	}
	
	//Check URL Mapping
	
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getACById(@PathVariable (name = "id" )long id)  throws NotFoundException {
			//if (id > ac.size() -1) {
				//throw new NotFoundException ("invalid id"); 
		return MeritBank.getAccountHolderByID(id); 
		}
	
	@PostMapping(value ="/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount, @PathVariable
			(name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException{
		AccountHolder a = MeritBank.getAccountHolderByID(id); 
		a.addCheckingAccount(checkingAccount); 
		return checkingAccount; 
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<BankAccount> getCheckingAccount(@PathVariable (name = "id") long id) throws NotFoundException {
		AccountHolder a = MeritBank.getAccountHolderByID(id); 
		return a.getCheckingAccounts(); 
	}
	@PostMapping(value ="/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@RequestBody @Valid SavingsAccount savingsAccount, @PathVariable
			(name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException{
		AccountHolder a = MeritBank.getAccountHolderByID(id); 
		a.addSavingsAccount(savingsAccount); 
		return savingsAccount; 
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<BankAccount> getSavingsAccount(@PathVariable (name = "id") long id) throws NotFoundException {
		AccountHolder a = MeritBank.getAccountHolderByID(id); 
		return a.getSavingsAccounts(); 
	}
	
	@PostMapping(value ="/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@RequestBody @Valid CDAccount cdAccount, @PathVariable
			(name = "id") long id) throws ExceedsCombinedBalanceLimitException, NotFoundException{
		AccountHolder a = MeritBank.getAccountHolderByID(id); 
		a.addCDAccount(cdAccount); 
		return cdAccount; 
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<BankAccount> getCDAccount(@PathVariable (name = "id") long id) throws NotFoundException {
		AccountHolder a = MeritBank.getAccountHolderByID(id); 
		return a.getCDAccounts(); 
	}
	
	@PostMapping(value ="/CDOffering")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering cdOffering) {
		MeritBank.addCDOffering(cdOffering); 
		return cdOffering; 
	}
	
	@GetMapping(value = "/CDOffering")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOffering> getCDOffering() throws NotFoundException {
		return MeritBank.getCDOfferings(); 
	}
	
		

}
