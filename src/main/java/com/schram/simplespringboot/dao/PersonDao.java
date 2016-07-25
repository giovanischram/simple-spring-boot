package com.schram.simplespringboot.dao;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.schram.simplespringboot.model.Person;

public interface PersonDao extends CrudRepository<Person, Long> {
	
	Collection<Person> findByName(String name);
	Collection<Person> findByNameAndDocument(String name, String document);
	Collection<Person> findByNameContaining(String name);
	
	Page<Person> findAll(Pageable pageable);
}