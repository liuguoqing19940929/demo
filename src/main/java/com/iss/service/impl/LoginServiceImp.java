package com.iss.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iss.dao.LoginRepository;
import com.iss.dao.ManageRepository;
import com.iss.dao.TeacherRepository;
import com.iss.pojo.Manage;
import com.iss.pojo.Teacher;
import com.iss.service.LoginService;
import com.iss.util.MD5;
@Service
public class LoginServiceImp implements LoginService {
	
	@Autowired
	private ManageRepository manageRepository;
	@Autowired
	private TeacherRepository teacherRepository;

	public Object login(String loginName, String loginPassword, String role) {
		
		if(role.equals("1")){
			//超级用户
			
			return manageRepository.findByManageNameAndManagePassword(loginName, loginPassword);
			
		}else if(role.equals("2")){
			try {
				loginPassword = MD5.encodeByMD5(loginPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//普通教师
			return teacherRepository.findByTeacherBianHaoAndTeacherPassword(loginName, loginPassword);
		}
		return null;
	}

}

