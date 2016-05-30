package com.schram.simplespringboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.schram.simplespringboot.model.Person;

public interface PersonDao extends CrudRepository<Person, Long> {
	
}