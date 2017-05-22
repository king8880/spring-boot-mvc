package com.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Journal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private Date created;
	private String summary;
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	public Journal(String title, String summary, String date) throws ParseException{
	this.title = title;
	this.summary = summary;
	this.created = format.parse(date);
	}
	
	public Journal(){}
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
	this.id = id;
	}
	
	@JsonBackReference
//	@JsonIgnore
//	@JsonManagedReference
	@ManyToMany(mappedBy = "journaux", fetch=FetchType.EAGER)
	private List<Author> authors = new ArrayList<Author>();
	
	
	
	public String getTitle() {
	return title;
	}
	public void setTitle(String title) {
	this.title = title;
	}
	public Date getCreated() {
	return created;
	}
	public void setCreated(Date created) {
	this.created = created;
	}
	public String getSummary() {
	return summary;
	}
	public void setSummary(String summary) {
	this.summary = summary;
	}
	public String getCreatedAsShort(){
	return format.format(created);
	}
	
	
	
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String toString(){
	StringBuilder value = new StringBuilder("JournalEntry(");
	value.append("Id: ");
	value.append(id);
	value.append(",Title: ");
	value.append(title);
	value.append(",Summary: ");
	value.append(summary);
	value.append(",Created: ");
	value.append(getCreatedAsShort());
	value.append(")");
	value.append(authors);
	return value.toString();
	}
}