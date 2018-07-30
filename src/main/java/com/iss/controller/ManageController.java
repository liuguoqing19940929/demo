package com.iss.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.iss.pojo.Teacher;
import com.iss.service.ManageService;
import com.iss.util.MD5;

import jxl.write.WritableWorkbook;

@Controller
@RequestMapping("manage")
public class ManageController {
	
	@Autowired
	private ManageService manageServiceImp;
	
	@ResponseBody
	@RequestMapping(value="/findTeacher",method = RequestMethod.POST)
	public String findTeacher(int rows, int page){
		Page<Teacher> pa = manageServiceImp.findTeacher(rows, page);
		List<Teacher> list = manageServiceImp.findTeacher();
		List<Teacher> list1 =new ArrayList<Teacher>();
		list1 = pa.getContent();
		Map map = new HashMap();
		map.put("total", list.size());
		map.put("rows", list1);
		return JSON.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveTeacher",method = RequestMethod.POST)
	public String saveTeacher(Teacher teacher){
		try {
			teacher.setTeacherPassword(MD5.encodeByMD5("111111"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Teacher teacher1 = manageServiceImp.saveTeacher(teacher);
		Map map = new HashMap();
		if(teacher1.getTeacherBianHao()!=null&&
				(!teacher1.getTeacherBianHao().equals(""))){
			map.put("key", "添加success！");
		}else{
			map.put("key", "添加error！");
		}
		return JSON.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteTeacher",method = RequestMethod.POST)
	public String deletTeacher(Teacher teacher){
		manageServiceImp.deleteTeacher(teacher);
		
		return JSON.toJSONString("success");
	}
	
	@ResponseBody
	@RequestMapping(value="/findCrosswiseProject", method = RequestMethod.POST)
	public String findCrosswiseProject(String teacherName, String time){
		
		return JSON.toJSONString(manageServiceImp.findCrosswiseProject(teacherName, time));
		
	}
	
	@ResponseBody
	@RequestMapping(value="/findPortaitProject", method = RequestMethod.POST)
	public String findPortaitProject(String teacherName, String time){
		
		return JSON.toJSONString(manageServiceImp.findPortaitProject(teacherName, time));
		
	}
	
	@ResponseBody
	@RequestMapping(value="/findPaper", method = RequestMethod.POST)
	public String findPaper(String paperName, String time, String paperAuthor){
		
		return JSON.toJSONString(manageServiceImp.findPaper(paperName, time, paperAuthor));
	}
	
	@ResponseBody
	@RequestMapping(value="/findPrint", method = RequestMethod.POST)
	public String findPrint(String printName, String printFirstAuthor){
		
		return JSON.toJSONString(manageServiceImp.findPrint(printName, printFirstAuthor));
	}

	@ResponseBody
	@RequestMapping(value="/findPatent", method = RequestMethod.POST)
	public String findPatent(String patentStartTime, String patentEndTime, String teacherName){
		
		return JSON.toJSONString(manageServiceImp.findPatent(patentStartTime, patentEndTime, teacherName));
	}
	
	@ResponseBody
	@RequestMapping(value="/export")
	public String export(String project, String startTime, String endTime){
		
		return manageServiceImp.export(project, startTime, endTime);
	}
}

