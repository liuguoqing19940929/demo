package com.iss.service;

import java.util.List;

import com.iss.pojo.PortaitProject;
import com.iss.pojo.Teacher;

public interface TeacherService {
	
	List<PortaitProject> findByteacherBianHao(String teacherBianHao);
	
	PortaitProject savePortaitProject(PortaitProject portaitProject);
	
	PortaitProject updatePortaitProject(PortaitProject portaitProject);
	
	void deletePortaitProject(PortaitProject portaitProject);
	
	Teacher updatePassword(String oldPassword, String newPassword, String teacherBianhao);
	

}

