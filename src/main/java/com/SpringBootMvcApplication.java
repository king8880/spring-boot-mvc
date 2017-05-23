package com;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.domain.Author;
import com.domain.Journal;
import com.repository.AuthorRepository;
import com.repository.JournalRepository;

@SpringBootApplication
public class SpringBootMvcApplication {
	
	@Bean
	InitializingBean saveData(JournalRepository repo, AuthorRepository aRepo){
	return () -> {
		Journal j =  new Journal("Get to know Spring Boot","Today I will learn SpringBoot",
				"01/01/2016");
		Author a = new Author("jim");
		a.getJournaux().add(j);
//		j.getAuthors().add(a);
//		repo.save(j);
		aRepo.save(a);
		
//		j = new Journal("Simple Spring Boot Project","I will do my first SpringBoot Project","01/02/2016");
//		a = new Author("bill");
//		a.setJournal(j);
//		j.getAuthors().add(a);
//		repo.save(j);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}
}
