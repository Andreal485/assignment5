package com.meritamerica.assignment5.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.CDOffering;

public interface CDOfferingRepository extends JpaRepository<CDOffering, Integer> {
	
	List<CDOffering> findById(int id);

}
