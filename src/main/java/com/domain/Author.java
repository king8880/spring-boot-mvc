package com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
//	@JsonBackReference
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "author_journal", joinColumns = @javax.persistence.JoinColumn(name = "author_id", referencedColumnName = "id"), 
    						inverseJoinColumns = @javax.persistence.JoinColumn(name = "journal_id", referencedColumnName = "id"))
	private List<Journal> journaux = new ArrayList<Journal>();
	
	public Author(){
		
	}
	
	
	
	public Author(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
//	@JsonManagedReference
//	@JsonIgnore
//	@JsonBackReference
//	@ManyToMany
//	private List<Journal> journaux = new ArrayList<Journal>();
	
	
	
	public String getName() {
		return name;
	}
	public List<Journal> getJournaux() {
		return journaux;
	}



	public void setJournaux(List<Journal> journaux) {
		this.journaux = journaux;
	}



	public void setName(String name) {
		this.name = name;
	}

//	public Journal getJournal() {
//		return journal;
//	}
//
//	public void setJournal(Journal journal) {
//		this.journal = journal;
//	}
	
	



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}



//	public List<Journal> getJournaux() {
//		return journaux;
//	}
//
//
//
//	public void setJournaux(List<Journal> journaux) {
//		this.journaux = journaux;
//	}
	
	

}
