package com.iss.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.dao.PortaitProjectRepository;
import com.iss.dao.TeacherRepository;
import com.iss.pojo.PortaitProject;
import com.iss.pojo.Teacher;
import com.iss.service.TeacherService;
import com.iss.util.MD5;
@Service
@Transactional
public class TeacherServiceImp implements TeacherService {
	
	@Autowired
	private PortaitProjectRepository portaitProjectRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;

	public List<PortaitProject> findByteacherBianHao(String teacherBianHao) {
		
		return portaitProjectRepository.findAll();
	}

	public PortaitProject savePortaitProject(PortaitProject portaitProject) {
		
		return portaitProjectRepository.save(portaitProject);
	}

	public PortaitProject updatePortaitProject(PortaitProject portaitProject) {
		portaitProject = portaitProjectRepository.save(portaitProject);
		return portaitProjectRepository.save(portaitProject);
	}

	public void deletePortaitProject(PortaitProject portaitProject) {
		// TODO Auto-generated method stub
		portaitProjectRepository.delete(portaitProject.getPortaitProjectId());;
	}

	public Teacher updatePassword(String oldPassword, String newPassword, String teacherBianhao) {
		Teacher teacher= teacherRepository.findByTeacherBianHao(teacherBianhao);
		String password = teacher.getTeacherPassword();
		try {
			if(MD5.encodeByMD5(oldPassword).equals(password)){
				teacher.setTeacherPassword(MD5.encodeByMD5(newPassword));
				teacherRepository.save(teacher);
			}
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return teacher;
	}

}

