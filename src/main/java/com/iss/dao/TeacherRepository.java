package com.iss.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.iss.pojo.Teacher;
@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Integer> {
	
	Page<Teacher> findAll(Pageable pageable);

	Teacher findByTeacherBianHaoAndTeacherPassword(String teacherBianHao, String teacherPassword);
	
	List<Teacher> findAll();
	
	@Query("select t from Teacher t")
	List<Teacher> findAll(int page, int pageSize);
	
	
	Teacher findByTeacherBianHao(String teacherBianHao);
}

