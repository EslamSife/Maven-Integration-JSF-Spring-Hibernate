package com.ldevs.springjsf.dao;

import java.util.List;

import com.ldevs.springjsf.model.Person;

public interface PersonDAO {

	public void addPerson(Person p);
    public List<Person> listPersons();
}
