package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Journal;
import com.repository.JournalRepository;

@RestController
@RequestMapping(value="journal")
public class JournalController {
	
	@Autowired
	JournalRepository journalRepo;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Journal>> listComptes(){
		List<Journal> journaux = journalRepo.findAll();
		
		if(journaux!=null && !journaux.isEmpty())
			return new ResponseEntity<List<Journal>>(journaux,HttpStatus.OK);
		return new ResponseEntity<List<Journal>>(HttpStatus.NOT_FOUND);
					
	}

}
