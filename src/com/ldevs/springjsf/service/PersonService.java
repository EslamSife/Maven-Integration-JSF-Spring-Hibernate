package com.ldevs.springjsf.service;

import java.util.List;

import com.ldevs.springjsf.model.Person;

public interface PersonService {
	
	
	public void addPerson(Person p);

	public List<Person> listPersons();
}
