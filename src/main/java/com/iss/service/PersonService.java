package com.iss.service;

import com.iss.pojo.Person;

public interface PersonService {
	public void addPerson(Person p);
	
	public Person findPersonByID(Integer id);
	
	public void deletePerson(Integer id);
	
	public void updatePerson(Person p);

}
