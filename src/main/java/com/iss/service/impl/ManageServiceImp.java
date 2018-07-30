package com.iss.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.iss.dao.CrosswiseProjectRepository;
import com.iss.dao.PaperRepository;
import com.iss.dao.PatentRepository;
import com.iss.dao.PortaitProjectRepository;
import com.iss.dao.PrintRepository;
import com.iss.dao.TeacherRepository;
import com.iss.pojo.CrosswiseProject;
import com.iss.pojo.Paper;
import com.iss.pojo.Patent;
import com.iss.pojo.PortaitProject;
import com.iss.pojo.Print;
import com.iss.pojo.Teacher;
import com.iss.service.ManageService;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Service
public class ManageServiceImp implements ManageService {
	
	private WritableWorkbook wwb=null;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private PortaitProjectRepository portaitProjectRepository;

	@Autowired
	private PaperRepository paperRepository;
	
	@Autowired
	private CrosswiseProjectRepository crosswiseProjectRepository;

	@Autowired
	private PrintRepository printRepository;
	
	@Autowired
	private PatentRepository patentRepository;

	public List<Teacher> findTeacher() {
		
		return teacherRepository.findAll();
	}
	
	public Page<Teacher> findTeacher(int pageSize, int page) {
		Page<Teacher> pa = teacherRepository.findAll(new PageRequest((page-1), pageSize));
		return pa;
	}

	public Teacher saveTeacher(Teacher teacher) {
		System.out.println(JSON.toJSON(teacher));
		System.out.println("Teacher is null");
		System.out.println(0);
		return teacherRepository.save(teacher);
	}

	public void deleteTeacher(Teacher teacher) {
		// 删除教师编号为teacher.getTeacherBianHao()所有的信息
		teacherRepository.delete(teacher);

	}

	public List<CrosswiseProject> findCrosswiseProject(String teacherName, String time) {
		List<CrosswiseProject> list = new ArrayList<CrosswiseProject>();
		if(teacherName.equals("0")){
			if(time.equals("0")){
				list = crosswiseProjectRepository.findAll();
			}else{
				list = crosswiseProjectRepository.findByCrosswiseProjectAchieveDate(time);
			}
		}else{
			if(time.equals("0")){
				list = crosswiseProjectRepository.findByCrosswiseProjectEmcee(teacherName);
			}else{
				list = crosswiseProjectRepository.findByCrosswiseProjectAchieveDateAndCrosswiseProjectEmcee(teacherName, time);
			}
		}
		return list;
	}

	public List<PortaitProject> findPortaitProject(String teacherName, String time) {
		List<PortaitProject> list = new ArrayList<PortaitProject>();
		if (teacherName.equals("0")) {
			if (time.equals("0")) {
				list = portaitProjectRepository.findAll();
			} else {
				list = portaitProjectRepository.findAll(time);
			}
		} else {
			if (time.equals("0")) {
				list = portaitProjectRepository.findByportaitProjectEmcee(teacherName);
			} else {
				list = portaitProjectRepository.findByportaitProjectEmceeAndportaitProjectAchieveTime(teacherName, time);
			}
		}
		return list;
	}

	public List<Paper> findPaper(String paperName, String time, String paperAuthor) {
		List<Paper> list = new ArrayList<Paper>();
		if(paperName.equals("0")){
			if(time.equals("0")){
				if(paperAuthor.equals("0")){
					list = paperRepository.findAll();
				}else{
					list = paperRepository.findByPaperAuthor(paperAuthor);
				}
			}else{
				if(paperAuthor.equals("0")){
					list = paperRepository.findByPaperTime(time);
				}else{
					list = paperRepository.findByPaperTimeAndPaperAuthor(time, paperAuthor);
				}
			}
		}else{
			if(time.equals("0")){
				if(paperAuthor.equals("0")){
					list = paperRepository.findByPaperName(paperName);
				}else{
					list = paperRepository.findByPaperNameAndPaperAuthor(paperName, paperAuthor);
				}
			}else{
				if(paperAuthor.equals("0")){
					list = paperRepository.findByPaperTimeAndPpaperName(time, paperName);
				}else{
					list = paperRepository.findByPaperTimeAndPaperAuthorAndPaperName(time, paperAuthor, paperName);
				}
			}
		}
		return list;
	}

	public List<Print> findPrint(String printName, String printFirstAuthor) {
		List<Print> list = new ArrayList<Print>();
		if(printName.equals("0")){
			if(printFirstAuthor.equals("0")){
				
				list = printRepository.findAll();
			}else{
				list = printRepository.findByPrintFirstAuthor(printFirstAuthor);
			}
		}else{
			if(printFirstAuthor.equals("0")){
				
				list = printRepository.findByPrintName(printName);
			}else{
				list = printRepository.findByPrintNameAndPrintFirstAuthor(printName, printFirstAuthor);
			}
		}
		return list;
	}

	public List<Patent> findPatent(String patentStartTime, String patentEndTime, String teacherName) {
		List<Patent> list = new ArrayList<Patent>();
		if(patentStartTime.equals("0")){
			if(patentEndTime.equals("0")){
				if(teacherName.equals("0")){
					list = patentRepository.findAll();
				}else{
					
				}
			}else{
				if(teacherName.equals("0")){
					
				}else{
					
				}
			}
		}else{
			
		}
		return list;
	}

	public String export(String project, String startTime, String endTime) {
			try {
				File file = new File("e://export/"+project+".xls"); 
				if(!file.exists()){
				file.createNewFile();
				}
				wwb=Workbook.createWorkbook(file);
				WritableSheet sheet=wwb.createSheet(project, 0);
				if(project.equals("portaitProject")){
					List<PortaitProject> list = new ArrayList<PortaitProject>();
					list = portaitProjectRepository.findByTime(startTime, endTime);
					Label labelprojectbianhao= new Label(0,0,"项目编号");
					Label labelprojectsource= new Label(1,0,"项目来源");
					Label labelprojectname= new Label(2,0,"项目名称");
					Label labelprojectMoney= new Label(3,0,"项目经费");
					Label labelteachername= new Label(4,0,"项目所属教师名");
					sheet.addCell(labelprojectbianhao);
					sheet.addCell(labelprojectsource);
					sheet.addCell(labelprojectname);
					sheet.addCell(labelprojectMoney);
					sheet.addCell(labelteachername);
					for (int i = 0; i < list.size(); i++) {
						Label labelprojectbianhao_i=new Label(0, i+1, list.get(i).getPortaitProjectBianMa()+"");
						Label labelprojectsource_i=new Label(1, i+1, list.get(i).getPortaitProjectSource()+"");
						Label labelprojectname_i=new Label(2, i+1, list.get(i).getPortaitProjectName()+"");
						Label labelprojectMoney_i=new Label(3, i+1, list.get(i).getPortaitProjectMoney()+"");
						Label labelteachername_i=new Label(4, i+1, list.get(i).getPortaitProjectEmcee()+"");
						sheet.addCell(labelprojectbianhao_i);
						sheet.addCell(labelprojectsource_i);
						sheet.addCell(labelprojectname_i);
						sheet.addCell(labelprojectMoney_i);
						sheet.addCell(labelteachername_i);
					}
					wwb.write();
					//关闭EXCEL工作簿对象
					System.out.println("数据库导出成功！");
					
				}else if(project.equals("crosswiseProject")){
					List<CrosswiseProject> list = new ArrayList<CrosswiseProject>();
					list = crosswiseProjectRepository.findByTime(startTime, endTime);
					Label labelprojectbianhao= new Label(0,0,"项目编号");
					Label labelprojectsource= new Label(1,0,"项目来源");
					Label labelprojectname= new Label(2,0,"项目名称");
					Label labelprojectMoney= new Label(3,0,"支持经费");
					Label labelprojectGetMoney= new Label(4,0,"到账经费");
					Label labelteachername= new Label(5,0,"项目所属教师名");
					sheet.addCell(labelprojectbianhao);
					sheet.addCell(labelprojectsource);
					sheet.addCell(labelprojectname);
					sheet.addCell(labelprojectMoney);
					sheet.addCell(labelteachername);
					for (int i = 0; i < list.size(); i++) {
						Label labelprojectbianhao_i=new Label(0, i+1, list.get(i).getCrosswiseProjectBianHao()+"");
						Label labelprojectsource_i=new Label(1, i+1, list.get(i).getCrosswiseProjectSource()+"");
						Label labelprojectname_i=new Label(2, i+1, list.get(i).getCrosswiseProjectName()+"");
						Label labelprojectMoney_i=new Label(3, i+1, list.get(i).getCrosswiseProjectMoney()+"");
						Label labelprojectGetMoney_i=new Label(4, i+1, list.get(i).getCrosswiseProjectGetMoney()+"");
						Label labelteachername_i=new Label(5, i+1, list.get(i).getCrosswiseProjectEmcee()+"");
						sheet.addCell(labelprojectbianhao_i);
						sheet.addCell(labelprojectsource_i);
						sheet.addCell(labelprojectname_i);
						sheet.addCell(labelprojectMoney_i);
						sheet.addCell(labelprojectGetMoney_i);
						sheet.addCell(labelteachername_i);
					}
					wwb.write();
					//关闭EXCEL工作簿对象
					System.out.println("数据库导出成功！");
				}else if(project.equals("paper")){
					
				}else if(project.equals("patent")){
					
				}else if(project.equals("print")){
					
				}else if(project.equals("studentCreate")){
					
				}else if(project.equals("studentMatch")){
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					wwb.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		return "e://export/"+project;
	}

	

}
