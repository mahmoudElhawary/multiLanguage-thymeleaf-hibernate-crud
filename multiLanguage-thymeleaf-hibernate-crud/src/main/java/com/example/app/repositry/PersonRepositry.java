package com.example.app.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Person;

@Repository
public interface PersonRepositry extends JpaRepository<Person, Integer> {
	
	public void deleteById(int id) ;
}
