package com.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.Author;
import com.domain.Journal;
import com.repository.AuthorRepository;
import com.repository.JournalRepository;

@Controller
public class JournalManagerController {
	
	@Autowired
	JournalRepository repo;
	
	@Autowired
	AuthorRepository repoA;

    @RequestMapping("/init")
    public String init(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
	
//    	Journal j;
//    	List<Author> as = new ArrayList<Author>();
//    	List<Journal> js = new ArrayList<Journal>();
//
//			try {
//				
//				
//				j = new Journal("Get to know Spring Boot","Today I will learn SpringBoot", "01/01/2016");
//				
//				Author a = new Author("jim");
//				as.add(a);
//				j.setAuthors(as);
//				js.add(j);
//				a.setJournaux(js);
//				repo.save(j);
//				repoA.save(a);
//
//				j = new Journal("Simple Spring Boot Project","I will do my first SpringBoot Project","01/02/2016");
//				a = new Author("bill");
//				as.add(a);
//				j.setAuthors(as);
//				js.add(j);
//				a.setJournaux(js);
//				repo.save(j);
//				repoA.save(a);
//				
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    	try {
    	Journal j = new Journal("Get to know Spring Boot","Today I will learn SpringBoot", "01/01/2016");
		
		Author a = new Author("jim");
		a.getJournaux().add(j);
		repoA.save(a);
		
		j = new Journal("Get to know Spring Boot","Today I will learn SpringBoot", "01/01/2016");
		
		a.getJournaux().add(j);
		repoA.save(a);
		
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Journal> journaux = repo.findAll();
    	
//    	List<Journal> journaux = new ArrayList<Journal>();
//    	Journal j = new Journal();
//    	j.setTitle("Lemonde");
//    	journaux.add(j);
    	
		model.addAttribute("journaux", journaux);
		
		
		List<Author> authors = repoA.findAll();
		
		
		System.out.println(authors);
		
		
//		journaux.stream().forEach(System.out::println);
        return "greeting";
    }
    
    @RequestMapping(value="/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Journal> getJournal(){
    	return repo.findAll();
    }
    
    @RequestMapping(value="/author", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Author> getAuthor(){
    	return repoA.findAll();
    }

}
