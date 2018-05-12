package com.ldevs.springjsf.service;

import java.util.List;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldevs.springjsf.dao.PersonDAO;
import com.ldevs.springjsf.model.Person;

@Service
@ManagedBean(name = "personService")
@SessionScoped
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}
	
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}
