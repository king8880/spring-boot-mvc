package com.ajs;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.domain.Author;
import com.domain.Journal;
import com.repository.AuthorRepository;
import com.repository.JournalRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMvcApplicationTests {
	
	@Autowired
	JournalRepository repo;
	
	@Autowired
	AuthorRepository repoA;

	@Test
	public void contextLoads() {
		Journal j;

			try {
				
				
				j = new Journal("Get to know Spring Boot","Today I will learn SpringBoot", "01/01/2016");
				
				Author a = new Author("jim");
				a.getJournaux().add(j);
				repoA.save(a);
//				j.getAuthors().add(a);
//				
//				repo.save(j);
//				repoA.save(a);

//				j = new Journal("Simple Spring Boot Project","I will do my first SpringBoot Project","01/02/2016");
//				a = new Author("bill");
//				as.add(a);
//				j.setAuthors(as);
//				js.add(j);
//				a.setJournaux(js);
//				repo.save(j);
//				repoA.save(a);
				Author aa = repoA.findAll().get(0);
				assertNull(repo.findAll());
//				System.out.println(aa.getJournaux());
//				System.out.println(repo.findAll());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
