package com.iss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iss.pojo.Teacher;
@Repository
public interface LoginRepository extends JpaRepository<Teacher, Integer> {

}

