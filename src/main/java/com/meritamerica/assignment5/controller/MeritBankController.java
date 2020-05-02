package com.meritamerica.assignment5.controller; 

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.exceptions.NoSuchResourceFoundException;
import com.meritamerica.assignment5.models.AccountHolder;

@RestController
public class MeritBankController {
	List<String> strings = new ArrayList<String>(); 
	
	List<AccountHolder> ac = new ArrayList<AccountHolder>(); 

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "Welcome to MeritBank"; 
	}
	
	@GetMapping(value="/strings")
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
	@GetMapping(value = "/ac")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccoungHolder(){
		return ac; 
	}
	@PostMapping(value = "/ac")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		ac.add(accountHolder); 
		return accountHolder; 
	}
	
	@GetMapping(value = "/ac/{id}")
	public AccountHolder getACById(@PathVariable int id) throws NoSuchResourceFoundException {
			if (id > ac.size() -1) {
				throw new NoSuchResourceFoundException ("invalid id");
			}
			return ac.get(id); 

		}
		

}
