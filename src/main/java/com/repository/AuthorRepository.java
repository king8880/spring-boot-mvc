package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Author;
import com.domain.Journal;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
