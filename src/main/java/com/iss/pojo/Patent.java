package com.iss.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patent")
public class Patent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patentId;
	//专利名
	private String patentName;
	//专利号
	private String patentBianMa;
	//专利类型
	private String patentType;
	//专利生效时间
	private String patentStartTime;
	//专利失效时间
	private String patentEndTime;
	//专利所属老师
	private String teacherName;
	//专利所属老师的编号
	private String teacherBianMa;
	
	public Integer getPatentId() {
		return patentId;
	}
	public void setPatentId(Integer patentId) {
		this.patentId = patentId;
	}
	public String getPatentName() {
		return patentName;
	}
	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}
	public String getPatentBianMa() {
		return patentBianMa;
	}
	public void setPatentBianMa(String patentBianMa) {
		this.patentBianMa = patentBianMa;
	}
	public String getPatentType() {
		return patentType;
	}
	public void setPatentType(String patentType) {
		this.patentType = patentType;
	}
	public String getPatentStartTime() {
		return patentStartTime;
	}
	public void setPatentStartTime(String patentStartTime) {
		this.patentStartTime = patentStartTime;
	}
	public String getPatentEndTime() {
		return patentEndTime;
	}
	public void setPatentEndTime(String patentEndTime) {
		this.patentEndTime = patentEndTime;
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
		builder.append("Patent [patentId=").append(patentId).append(", patentName=").append(patentName)
				.append(", patentBianMa=").append(patentBianMa).append(", patentType=").append(patentType)
				.append(", patentStartTime=").append(patentStartTime).append(", patentEndTime=").append(patentEndTime)
				.append(", teacherName=").append(teacherName).append(", teacherBianMa=").append(teacherBianMa)
				.append("]");
		return builder.toString();
	}
}

