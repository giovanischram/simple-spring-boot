package com.schram.simplespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schram.simplespringboot.dao.PersonDao;
import com.schram.simplespringboot.model.Person;


@Controller
@RequestMapping("/persons")
public class PersonController {

	private static final String PERSONS_KEY = "persons";

	private static final String VIEW = "Persons";
	
	@Autowired private PersonDao personDao;
	
	@RequestMapping
	public ModelAndView getPersons() {
		ModelAndView mv = new ModelAndView(VIEW);
		Iterable<Person> persons = personDao.findAll();
		mv.addObject(PERSONS_KEY, persons);
		mv.addObject(new Person());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Person person) {
		personDao.save(person);
		return getPersons();
	}
}