package com.meritamerica.assignment5.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.models.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

	
	AccountHolder findById(long id);
}
