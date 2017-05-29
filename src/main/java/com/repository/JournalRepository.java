package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> { 
	
	public Journal findByTitle(String title);
	
	
}
