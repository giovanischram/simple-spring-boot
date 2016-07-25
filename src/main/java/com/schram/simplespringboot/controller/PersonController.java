package com.schram.simplespringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schram.simplespringboot.dao.PersonDao;
import com.schram.simplespringboot.model.Person;

@Controller
@RequestMapping("/persons")
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	private static final String VIEW = "Persons";
	private static final String PERSONS_KEY = "persons";

	@Autowired private PersonDao personDao;
	
	@RequestMapping
	public ModelAndView getPersons() {
		LOGGER.info("Searching all persons.");
		ModelAndView mv = new ModelAndView(VIEW);
		// Iterable<Person> persons = personDao.findAll();
		
		// Accessing the first page of Person by a page size of 2
		Page<Person> persons = personDao.findAll(new PageRequest(0, 2));
		
		mv.addObject(PERSONS_KEY, persons);
		mv.addObject(new Person());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Person person) {
		LOGGER.info("Saving person: " + person.getName());
		personDao.save(person);
		return getPersons();
	}
}
