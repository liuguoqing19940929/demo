package com.iss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iss.pojo.Print;
@Repository
public interface PrintRepository extends JpaRepository<Print, Integer> {
	
	List<Print> findByPrintName(String printName);
	
	List<Print> findByPrintFirstAuthor(String printFirstAuthor);
	
	List<Print> findByPrintNameAndPrintFirstAuthor(String printName, String printFirstAuthor);
	

}

