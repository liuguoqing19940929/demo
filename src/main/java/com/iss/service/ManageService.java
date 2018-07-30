package com.iss.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iss.pojo.CrosswiseProject;
import com.iss.pojo.Paper;
import com.iss.pojo.Patent;
import com.iss.pojo.PortaitProject;
import com.iss.pojo.Print;
import com.iss.pojo.Teacher;

public interface ManageService {
	
	List<Teacher> findTeacher();
	
	Page<Teacher> findTeacher(int rows, int page);
	
	Teacher saveTeacher(Teacher teacher);
	
	void deleteTeacher(Teacher teacher);
	
	List<PortaitProject> findPortaitProject(String teacherName, String time);
	
	List<CrosswiseProject> findCrosswiseProject(String teacherName, String time);
	
	List<Paper> findPaper(String paperName, String time, String paperAuthor);
	
	List<Print> findPrint(String printName, String printFirstAuthor);
	
	List<Patent> findPatent(String patentStartTime, String patentEndTime, String teacherName);
	
	String export(String project, String startTime, String endTime);

}

