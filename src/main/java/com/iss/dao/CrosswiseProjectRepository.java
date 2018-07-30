package com.iss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iss.pojo.CrosswiseProject;
@Repository
public interface CrosswiseProjectRepository extends JpaRepository<CrosswiseProject, Integer> {
	
	List<CrosswiseProject> findAll();
	
	@Query("select c from CrosswiseProject c where c.crosswiseProjectAchieveDate > ?1 and c.crosswiseProjectAchieveDate < ?2")
	List<CrosswiseProject> findByTime(String startTime, String endTime);
	
	List<CrosswiseProject> findByCrosswiseProjectEmcee(String teacherNmae);
	
	@Query("select c from CrosswiseProject c where c.crosswiseProjectAchieveDate < ?1")
	List<CrosswiseProject> findByCrosswiseProjectAchieveDate(String crosswiseProjectAchieveDate);
	
	@Query("select c from CrosswiseProject c where c.crosswiseProjectAchieveDate < ?2 and c.crosswiseProjectEmcee = ?1")
	List<CrosswiseProject> findByCrosswiseProjectAchieveDateAndCrosswiseProjectEmcee(String teacherName, String crosswiseProjectAchieveDate);

}

