package com.iss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iss.pojo.Paper;
@Repository
public interface PaperRepository extends JpaRepository<Paper, Integer>{
	
	List<Paper> findAll();
	
	List<Paper> findByPaperAuthor(String paperAuthor);
	
	List<Paper> findByPaperName(String paperName);
	
	List<Paper> findByPaperNameAndPaperAuthor(String paperName, String paperAuthor);
	
	@Query("select pa from Paper pa where pa.paperTime<?1")
	List<Paper> findByPaperTime(String paperTime);
	
	@Query("select pa from Paper pa where pa.paperTime<?1 and pa.paperAuthor=?2")
	List<Paper> findByPaperTimeAndPaperAuthor(String paperTime, String paperAuthor);
	
	@Query("select pa from Paper pa where pa.paperTime<?1 and pa.paperName=?2")
	List<Paper> findByPaperTimeAndPpaperName(String paperTime, String paperName);
	
	@Query("select pa from Paper pa where pa.paperTime<?1 and pa.paperAuthor=?2 and pa.paperName=?3")
	List<Paper> findByPaperTimeAndPaperAuthorAndPaperName(String paperTime, String paperAuthor, String paperName);

}

