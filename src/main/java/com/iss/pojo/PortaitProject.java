package com.iss.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//纵向项目
@Entity
@Table(name="portaitproject")
public class PortaitProject implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer portaitProjectId;
	//项目来源
	@Column(nullable = false)
	private String portaitProjectSource;
	//项目名
	@Column(nullable = false)
	private String portaitProjectName;
	//项目编码
	@Column(unique = true, nullable = false)
	private String portaitProjectBianMa;
	//项目经费
	@Column(nullable = false)
	private Double portaitProjectMoney;
	//项目完成时间
	@Column( nullable = false)
	private String portaitProjectAchieveTime;
	//主持人等于teacherName
	@Column(nullable = false)
	private String portaitProjectEmcee;
	//项目参与人
	private String portaitProjectPartake;
	//项目是否获奖
	@Column(nullable = false)
	private String portaitProjectPrize;
	//获奖级别
	private String portaitProjectPrizeLevel;
	//项目获奖时间
	private String portaitProjectPrizeTime;
	//项目类型
	private String portaitProjectType;
	//附件
	private String portaitProjectFuJian;
	/*//教师名
	private String teacherName;*/
	//教师编码
	@Column(unique = true, nullable = false)
	private String teacherBianHao;
	public Integer getPortaitProjectId() {
		return portaitProjectId;
	}
	public void setPortaitProjectId(Integer portaitProjectId) {
		this.portaitProjectId = portaitProjectId;
	}
	public String getPortaitProjectSource() {
		return portaitProjectSource;
	}
	public void setPortaitProjectSource(String portaitProjectSource) {
		this.portaitProjectSource = portaitProjectSource;
	}
	public String getPortaitProjectName() {
		return portaitProjectName;
	}
	public void setPortaitProjectName(String portaitProjectName) {
		this.portaitProjectName = portaitProjectName;
	}
	public String getPortaitProjectBianMa() {
		return portaitProjectBianMa;
	}
	public void setPortaitProjectBianMa(String portaitProjectBianMa) {
		this.portaitProjectBianMa = portaitProjectBianMa;
	}
	public Double getPortaitProjectMoney() {
		return portaitProjectMoney;
	}
	public void setPortaitProjectMoney(Double portaitProjectMoney) {
		this.portaitProjectMoney = portaitProjectMoney;
	}
	public String getPortaitProjectAchieveTime() {
		return portaitProjectAchieveTime;
	}
	public void setPortaitProjectAchieveTime(String portaitProjectAchieveTime) {
		this.portaitProjectAchieveTime = portaitProjectAchieveTime;
	}
	public String getPortaitProjectEmcee() {
		return portaitProjectEmcee;
	}
	public void setPortaitProjectEmcee(String portaitProjectEmcee) {
		this.portaitProjectEmcee = portaitProjectEmcee;
	}
	public String getPortaitProjectPartake() {
		return portaitProjectPartake;
	}
	public void setPortaitProjectPartake(String portaitProjectPartake) {
		this.portaitProjectPartake = portaitProjectPartake;
	}
	public String getPortaitProjectPrize() {
		return portaitProjectPrize;
	}
	public void setPortaitProjectPrize(String portaitProjectPrize) {
		this.portaitProjectPrize = portaitProjectPrize;
	}
	public String getPortaitProjectPrizeLevel() {
		return portaitProjectPrizeLevel;
	}
	public void setPortaitProjectPrizeLevel(String portaitProjectPrizeLevel) {
		this.portaitProjectPrizeLevel = portaitProjectPrizeLevel;
	}
	public String getPortaitProjectPrizeTime() {
		return portaitProjectPrizeTime;
	}
	public void setPortaitProjectPrizeTime(String portaitProjectPrizeTime) {
		this.portaitProjectPrizeTime = portaitProjectPrizeTime;
	}
	/*public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}*/
	public String getTeacherBianHao() {
		return teacherBianHao;
	}
	public void setTeacherBianHao(String teacherBianHao) {
		this.teacherBianHao = teacherBianHao;
	}
	public String getPortaitProjectType() {
		return portaitProjectType;
	}
	public void setPortaitProjectType(String portaitProjectType) {
		this.portaitProjectType = portaitProjectType;
	}
	public String getPortaitProjectFuJian() {
		return portaitProjectFuJian;
	}
	public void setPortaitProjectFuJian(String portaitProjectFuJian) {
		this.portaitProjectFuJian = portaitProjectFuJian;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PortaitProject [portaitProjectId=").append(portaitProjectId).append(", portaitProjectSource=")
				.append(portaitProjectSource).append(", portaitProjectName=").append(portaitProjectName)
				.append(", portaitProjectBianMa=").append(portaitProjectBianMa).append(", portaitProjectMoney=")
				.append(portaitProjectMoney).append(", portaitProjectAchieveTime=").append(portaitProjectAchieveTime)
				.append(", portaitProjectEmcee=").append(portaitProjectEmcee).append(", portaitProjectPartake=")
				.append(portaitProjectPartake).append(", portaitProjectPrize=").append(portaitProjectPrize)
				.append(", portaitProjectPrizeLevel=").append(portaitProjectPrizeLevel)
				.append(", portaitProjectPrizeTime=").append(portaitProjectPrizeTime).append(", portaitProjectType=")
				.append(portaitProjectType).append(", portaitProjectFuJian=").append(portaitProjectFuJian)
				.append(", teacherBianHao=").append(teacherBianHao).append("]");
		return builder.toString();
	}
	
	
	
	
	

}

