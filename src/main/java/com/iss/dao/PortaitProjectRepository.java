package com.iss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.iss.pojo.PortaitProject;
@Repository
public interface PortaitProjectRepository extends CrudRepository<PortaitProject, Integer> {
	
	//List<PortaitProject> findByportaitProjectEmcee(String portaitProjectEmcee);
	
	/*@Query("select * from portaitproject where portaitProjectAchieveTime < ?1")
	List<PortaitProject> findAll(String time);*/
	
	List<PortaitProject> findAll();
	
	@Query("select p from PortaitProject p where p.portaitProjectAchieveTime > ?1 and p.portaitProjectAchieveTime < ?2")
	List<PortaitProject> findByTime(String startTime, String endTime);
	
	@Query("select p from PortaitProject p where p.portaitProjectAchieveTime < ?1")
	List<PortaitProject> findAll(String time);
	
	@Query("select p from PortaitProject p where p.portaitProjectEmcee = ?1")
	List<PortaitProject> findByportaitProjectEmcee(String teacherName);
	
	@Query("select p from PortaitProject p where p.portaitProjectEmcee = ?1 and p.portaitProjectAchieveTime < ?2")
	List<PortaitProject> findByportaitProjectEmceeAndportaitProjectAchieveTime(String teacherName, String time);
}

