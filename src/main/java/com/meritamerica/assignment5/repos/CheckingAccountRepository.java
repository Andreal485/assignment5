package com.meritamerica.assignment5.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.models.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
	
	List<CheckingAccount> findByAccountHolders(long id);

}
