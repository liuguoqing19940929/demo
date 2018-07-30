package com.iss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iss.pojo.Patent;
@Repository
public interface PatentRepository extends JpaRepository<Patent, Integer> {

}

