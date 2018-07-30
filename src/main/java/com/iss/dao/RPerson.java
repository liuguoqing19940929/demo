package com.iss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iss.pojo.Person;

public interface RPerson extends JpaRepository<Person, Integer> {

}
