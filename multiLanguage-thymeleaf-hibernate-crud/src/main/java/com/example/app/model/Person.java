package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique=true)
	private int id ;
	
	@Size(min=4,max=11,message="please check your name")
	@Column(name="fullName",nullable=false)
	private String fullName ;
	
	@Column(name="BD",nullable=true) 
	private int BD ;
	
	
	public Person() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getBD() {
		return BD;
	}
	public void setBD(int bD) {
		BD = bD;
	}
	
	
}
