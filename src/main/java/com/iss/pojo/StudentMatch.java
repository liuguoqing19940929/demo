package com.iss.pojo;

import java.io.Serializable;

public class StudentMatch implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer studentMatchId;
	//学生大赛名
	private String studentMatchName;
	//学生大赛级别
	private String studentMatchLevel;
	//学生大赛参加学生名
	private String studentMatchStudentName;
	//学生大赛是否获奖
	private String studentMatchPrize;
	//学生大赛获奖级别
	private String studentMatchPrizeLevel;
	//学生大赛获奖时间
	private String studentMatchPrizeTime;
	
	private String teacherName;
	
	private String teacherBianMa;

	public Integer getStudentMatchId() {
		return studentMatchId;
	}

	public void setStudentMatchId(Integer studentMatchId) {
		this.studentMatchId = studentMatchId;
	}

	public String getStudentMatchName() {
		return studentMatchName;
	}

	public void setStudentMatchName(String studentMatchName) {
		this.studentMatchName = studentMatchName;
	}

	public String getStudentMatchLevel() {
		return studentMatchLevel;
	}

	public void setStudentMatchLevel(String studentMatchLevel) {
		this.studentMatchLevel = studentMatchLevel;
	}

	public String getStudentMatchStudentName() {
		return studentMatchStudentName;
	}

	public void setStudentMatchStudentName(String studentMatchStudentName) {
		this.studentMatchStudentName = studentMatchStudentName;
	}

	public String getStudentMatchPrize() {
		return studentMatchPrize;
	}

	public void setStudentMatchPrize(String studentMatchPrize) {
		this.studentMatchPrize = studentMatchPrize;
	}

	public String getStudentMatchPrizeLevel() {
		return studentMatchPrizeLevel;
	}

	public void setStudentMatchPrizeLevel(String studentMatchPrizeLevel) {
		this.studentMatchPrizeLevel = studentMatchPrizeLevel;
	}

	public String getStudentMatchPrizeTime() {
		return studentMatchPrizeTime;
	}

	public void setStudentMatchPrizeTime(String studentMatchPrizeTime) {
		this.studentMatchPrizeTime = studentMatchPrizeTime;
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
		builder.append("StudentMatch [studentMatchId=").append(studentMatchId).append(", studentMatchName=")
				.append(studentMatchName).append(", studentMatchLevel=").append(studentMatchLevel)
				.append(", studentMatchStudentName=").append(studentMatchStudentName).append(", studentMatchPrize=")
				.append(studentMatchPrize).append(", studentMatchPrizeLevel=").append(studentMatchPrizeLevel)
				.append(", studentMatchPrizeTime=").append(studentMatchPrizeTime).append(", teacherName=")
				.append(teacherName).append(", teacherBianMa=").append(teacherBianMa).append("]");
		return builder.toString();
	}

}

