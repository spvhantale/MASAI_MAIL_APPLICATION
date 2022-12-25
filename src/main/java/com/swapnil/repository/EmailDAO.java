package com.swapnil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapnil.model.Email;

@Repository
public interface EmailDAO extends JpaRepository<Email, Integer>{

	
	public Email findByEmail(String email);
	
	
}
