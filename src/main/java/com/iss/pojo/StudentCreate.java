package com.iss.pojo;

import java.io.Serializable;

public class StudentCreate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer studentCreateId;
	//指导学生创新名
	private String studentCreateName;
	//指导学生创新编码
	private String studentCreateBianMa;
	//指导学生创新级别
	private String studentCreateLevel;
	//指导学生创新完成时间
	private String studentCreateAchieveTime;
	//指导学生创新学生名
	private String studentCreateStudentName;
	//指导学生创新是否获奖
	private String studentCreatePrize;
	//指导学生创新获奖级别
	private String studentCreatePrizeLevel;
	//指导学生创新获奖时间
	private String studentCreatePrizeTime;
	
	private String teacherName;
	
	private String teacherBianMa;
	public Integer getStudentCreateId() {
		return studentCreateId;
	}
	public void setStudentCreateId(Integer studentCreateId) {
		this.studentCreateId = studentCreateId;
	}
	public String getStudentCreateName() {
		return studentCreateName;
	}
	public void setStudentCreateName(String studentCreateName) {
		this.studentCreateName = studentCreateName;
	}
	public String getStudentCreateBianMa() {
		return studentCreateBianMa;
	}
	public void setStudentCreateBianMa(String studentCreateBianMa) {
		this.studentCreateBianMa = studentCreateBianMa;
	}
	public String getStudentCreateLevel() {
		return studentCreateLevel;
	}
	public void setStudentCreateLevel(String studentCreateLevel) {
		this.studentCreateLevel = studentCreateLevel;
	}
	public String getStudentCreateAchieveTime() {
		return studentCreateAchieveTime;
	}
	public void setStudentCreateAchieveTime(String studentCreateAchieveTime) {
		this.studentCreateAchieveTime = studentCreateAchieveTime;
	}
	public String getStudentCreateStudentName() {
		return studentCreateStudentName;
	}
	public void setStudentCreateStudentName(String studentCreateStudentName) {
		this.studentCreateStudentName = studentCreateStudentName;
	}
	public String getStudentCreatePrize() {
		return studentCreatePrize;
	}
	public void setStudentCreatePrize(String studentCreatePrize) {
		this.studentCreatePrize = studentCreatePrize;
	}
	public String getStudentCreatePrizeLevel() {
		return studentCreatePrizeLevel;
	}
	public void setStudentCreatePrizeLevel(String studentCreatePrizeLevel) {
		this.studentCreatePrizeLevel = studentCreatePrizeLevel;
	}
	public String getStudentCreatePrizeTime() {
		return studentCreatePrizeTime;
	}
	public void setStudentCreatePrizeTime(String studentCreatePrizeTime) {
		this.studentCreatePrizeTime = studentCreatePrizeTime;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherBianMa() {
		return teacherBianMa;
	}
	public void setTeacherBianMa(String teacherBianMa) {
		this.teacherBianMa = teacherBianMa;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentCreate [studentCreateId=").append(studentCreateId).append(", studentCreateName=")
				.append(studentCreateName).append(", studentCreateBianMa=").append(studentCreateBianMa)
				.append(", studentCreateLevel=").append(studentCreateLevel).append(", studentCreateAchieveTime=")
				.append(studentCreateAchieveTime).append(", studentCreateStudentName=").append(studentCreateStudentName)
				.append(", studentCreatePrize=").append(studentCreatePrize).append(", studentCreatePrizeLevel=")
				.append(studentCreatePrizeLevel).append(", studentCreatePrizeTime=").append(studentCreatePrizeTime)
				.append(", teacherName=").append(teacherName).append(", teacherBianMa=").append(teacherBianMa)
				.append("]");
		return builder.toString();
	}
	
	
	

}

