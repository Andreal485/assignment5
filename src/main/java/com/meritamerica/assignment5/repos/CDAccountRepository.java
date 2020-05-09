package com.meritamerica.assignment5.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.models.CDAccount;

public interface CDAccountRepository extends JpaRepository<CDAccount, Long> {

	
	List<CDAccount> findByAccountHolder(long id);
}
