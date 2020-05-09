package com.meritamerica.assignment5.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.models.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long > {

}
