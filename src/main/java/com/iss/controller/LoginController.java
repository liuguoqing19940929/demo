package com.iss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iss.pojo.Manage;
import com.iss.pojo.Teacher;
import com.iss.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginServiceImp;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, String loginName, String loginPassword, String role){
		ModelAndView mav = new ModelAndView();
		if(loginName!=null && loginPassword !=null && role !=null){
			Object object = loginServiceImp.login(loginName, loginPassword, role);
			if(object instanceof Manage){
				if(((Manage) object).getManageId() !=null){
					session.setAttribute("nowUser", ((Manage) object).getManageId());
					session.setAttribute("admin", ((Manage) object).getManageName());
					mav.addObject("admin", ((Manage) object).getManageName());
					mav.setViewName("manage");
				}else{
					mav.setViewName("login");
					mav.addObject("status", "请输入正确的用户名和密码！");
				}
			}else if(object instanceof Teacher){
				if(((Teacher) object).getTeacherId() !=null){
					session.setAttribute("teacherBianHao", ((Teacher) object).getTeacherBianHao());
					session.setAttribute("teacherName", ((Teacher) object).getTeacherName());
					mav.setViewName("teacher");					
				}else{
					mav.setViewName("login");
					mav.addObject("status", "请输入正确的用户名和密码！");
				}
			}else{
				mav.addObject("status", "请输入正确的用户名和密码！");
				mav.setViewName("login");
			}
			
		}else{
			mav.addObject("status", "请输入正确的用户名和密码和选择对应的权限！");
			mav.setViewName("login");
		}
		/*if(loginName!=null && loginPassword !=null && role !=null){
			session.setAttribute("nowUser","");
			Object object = loginServiceImp.find(loginName, loginPassword, role);
			if(object instanceof Manage){
				if(((Manage) object).getManageId() !=null){
					session.setAttribute("nowUser", ((Manage) object).getManageId());
					session.setAttribute("admin", ((Manage) object).getManageName());
					mav.addObject("admin", ((Manage) object).getManageName());
					mav.setViewName("manage");
				}else{
					mav.setViewName("login");
					mav.addObject("status", "请输入正确的用户名和密码！");
				}
			}else if(object instanceof Teacher){
				if(((Teacher) object).getTeacherId() !=null){
					session.setAttribute("teacherBianHao", ((Teacher) object).getTeacherBianHao());
					session.setAttribute("teacherName", ((Teacher) object).getTeacherName());
					mav.setViewName("teacher");					
				}else{
					mav.setViewName("login");
					mav.addObject("status", "请输入正确的用户名和密码！");
				}
			}else{
				mav.addObject("status", "请输入正确的用户名和密码！");
			}
		}else{
			mav.addObject("status", "请输入正确的用户名和密码和选择对应的权限！");
			mav.setViewName("login");
		}*/
		return mav;
	}
}

