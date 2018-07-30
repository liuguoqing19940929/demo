package com.iss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.dao.RPerson;
import com.iss.pojo.Person;
import com.iss.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	RPerson rPerson;
	@Transactional
	public void addPerson(Person p) {
		rPerson.save(p);

	}
	@Transactional(readOnly=true)
	public Person findPersonByID(Integer id) {
		return rPerson.findOne(id);		
	}
	@Transactional
	public void deletePerson(Integer id) {
		rPerson.delete(id);

	}

	public void updatePerson(Person p) {
		rPerson.save(p);

	}

}
