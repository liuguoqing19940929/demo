package com.iss.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iss.pojo.Person;
import com.iss.service.PersonService;

@Controller
@RequestMapping("/")
public class PersonController {
	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	PersonService personSericeImpl;
	@RequestMapping("add")
	public String addPerson(){
		Person person=new Person();
		person.setName("李华");
		personSericeImpl.addPerson(person);
		return "success";
	}
	@RequestMapping("delete")
	public String deletePerson(){
		personSericeImpl.deletePerson(1);
		return "success";
	}
	@RequestMapping("find")
	public String findPerson(){
		Person p=personSericeImpl.findPersonByID(1);
		System.out.println(p.getId()+":"+p.getName());
		return "success";
	}
	@RequestMapping("update")
	public String updatePerson(){
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Person p=em.find(Person.class, 1);
		System.out.println(p.getName());
		p.setName("张三");
		em.merge(p);
		em.getTransaction().commit();
		return "success";
	}
	@RequestMapping("update1")
	public String updatePerson1(){
		Person p=personSericeImpl.findPersonByID(1);
		p.setName("李四");
		personSericeImpl.updatePerson(p);
		return "success";
	}
}
