package com.iss.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iss.pojo.PortaitProject;
import com.iss.pojo.Teacher;
import com.iss.service.TeacherService;
import com.iss.util.MD5;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private TeacherService teacherServiceImp;
	
	@ResponseBody
	@RequestMapping(value="/findPortaitProject", method = RequestMethod.POST)
	public String findPortaitProject(){
		String s =(String) session.getAttribute("teacherBianHao");
		return JSON.toJSONString(
				teacherServiceImp.findByteacherBianHao((String) session.getAttribute("teacherBianHao")));
	}
	
	@ResponseBody
	@RequestMapping(value="/savePortaitProject", method = RequestMethod.POST)
	public String savePortaitProject(PortaitProject portaitProject){
		portaitProject.setTeacherBianHao((String) session.getAttribute("teacherBianHao"));
		portaitProject.setPortaitProjectEmcee((String) session.getAttribute("teacherName"));
		
		return JSON.toJSONString(teacherServiceImp.savePortaitProject(portaitProject));
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePortaitProject")
	public String updatePortaitProject(PortaitProject portaitProject){
		portaitProject.setTeacherBianHao((String) session.getAttribute("teacherBianHao"));
		portaitProject.setPortaitProjectEmcee((String) session.getAttribute("teacherName"));
		//portaitProject = teacherServiceImp.updatePortaitProject(portaitProject);
		return JSON.toJSONString(teacherServiceImp.updatePortaitProject(portaitProject));
	}
	
	@ResponseBody
	@RequestMapping(value="/deletePortaitProject", method = RequestMethod.POST)
	public String deletePortaitProject(PortaitProject portaitProject, MultipartFile file){
		teacherServiceImp.deletePortaitProject(portaitProject);
		return JSON.toJSONString("success");
	}
	
	@ResponseBody
	@RequestMapping(value="/upFile", method = RequestMethod.POST)
	public String upFile(MultipartFile file) throws IllegalStateException, IOException{
		Map<String, String> map = new HashMap<String, String>();
		if(!(file.getSize()>0)){
			map.put("key", "");
			return JSON.toJSONString(map);
		}
		String realPath = session.getServletContext().getRealPath(file.getName());
		file.getOriginalFilename();
		String path1 = session.getServletContext().getRealPath("/");
		File f = new File(path1).getParentFile();
		f = new File(f, "fi");
		if(!f.exists()){
			f.mkdir();
		}
		file.transferTo(new File(f,file.getOriginalFilename()));
		map.put("key", "/fi/"+file.getOriginalFilename());
		return JSON.toJSONString(map);
	}
	@ResponseBody
	@RequestMapping(value="/test", method = RequestMethod.POST)
	public String upFile1(String id1,MultipartFile file){
		String i = file.getName();
		
		return JSON.toJSONString("success");
	}
	
	/*@ResponseBody*/
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(String oldPassword, String newPassword, String confirmPassword){
		ModelAndView mav = new ModelAndView();
		//String path = session.getServletContext().getContextPath();
		mav.setViewName("teacherUpdatePassword");
		if((oldPassword != null && newPassword !=null && confirmPassword!=null) && 
				(!oldPassword.equals("") && !newPassword.equals("") && !confirmPassword.equals(""))){
			if(newPassword.equals(confirmPassword)){
				String teacherBianhao = (String) session.getAttribute("teacherBianHao");
				Teacher teacher = teacherServiceImp.updatePassword(oldPassword, newPassword, teacherBianhao);
				try {
					if(teacher.getTeacherPassword().equals(MD5.encodeByMD5(newPassword))){
						mav.addObject("status", "密码修改成功！");
					}else{
						mav.addObject("status", "旧密码错误！");
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				mav.addObject("status", "确认密码和新密码不一致");
			}
		}else{
			mav.addObject("status", "有的密码未输入");
		}
		return mav;
	}

}

