package com.iss.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//横向项目
@Entity
@Table(name="crosswiseproject")
public class CrosswiseProject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer crosswiseProjectId;
	//项目编号
	@Column(unique = true, nullable = false)
	private String crosswiseProjectBianHao;
	//项目名称
	private String crosswiseProjectName;
	//项目来源
	private String crosswiseProjectSource;
	//合作单位
	private String crosswiseProjectCompanion;
	//到账经费
	private Double crosswiseProjectGetMoney;
	//支持经费
	private Double crosswiseProjectMoney;
	//完成时间
	private String crosswiseProjectAchieveDate;
	//主持人 相当于teacherName
	private String crosswiseProjectEmcee;
	//主要参与人
	private String crosswiseProjectPartake;
	//是否获奖

	private String crosswiseProjectPrize;
	//或将级别
	
	private String crosswiseProjectPrizeLevel;
	//获奖时间
	
	private String crosswiseProjectPrizeTime;
	/*//教师名
	private String teacherName;*/
	//教师编码
	private String teacherBianHao;
	public int getCrosswiseProjectId() {
		return crosswiseProjectId;
	}
	public void setCrosswiseProjectId(int crosswiseProjectId) {
		this.crosswiseProjectId = crosswiseProjectId;
	}
	public String getCrosswiseProjectBianHao() {
		return crosswiseProjectBianHao;
	}
	public void setCrosswiseProjectBianHao(String crosswiseProjectBianHao) {
		this.crosswiseProjectBianHao = crosswiseProjectBianHao;
	}
	public String getCrosswiseProjectName() {
		return crosswiseProjectName;
	}
	public void setCrosswiseProjectName(String crosswiseProjectName) {
		this.crosswiseProjectName = crosswiseProjectName;
	}
	public String getCrosswiseProjectSource() {
		return crosswiseProjectSource;
	}
	public void setCrosswiseProjectSource(String crosswiseProjectSource) {
		this.crosswiseProjectSource = crosswiseProjectSource;
	}
	public String getCrosswiseProjectCompanion() {
		return crosswiseProjectCompanion;
	}
	public void setCrosswiseProjectCompanion(String crosswiseProjectCompanion) {
		this.crosswiseProjectCompanion = crosswiseProjectCompanion;
	}
	public Double getCrosswiseProjectGetMoney() {
		return crosswiseProjectGetMoney;
	}
	public void setCrosswiseProjectGetMoney(Double crosswiseProjectGetMoney) {
		this.crosswiseProjectGetMoney = crosswiseProjectGetMoney;
	}
	public Double getCrosswiseProjectMoney() {
		return crosswiseProjectMoney;
	}
	public void setCrosswiseProjectMoney(Double crosswiseProjectMoney) {
		this.crosswiseProjectMoney = crosswiseProjectMoney;
	}
	public String getCrosswiseProjectAchieveDate() {
		return crosswiseProjectAchieveDate;
	}
	public void setCrosswiseProjectAchieveDate(String crosswiseProjectAchieveDate) {
		this.crosswiseProjectAchieveDate = crosswiseProjectAchieveDate;
	}
	public String getCrosswiseProjectEmcee() {
		return crosswiseProjectEmcee;
	}
	public void setCrosswiseProjectEmcee(String crosswiseProjectEmcee) {
		this.crosswiseProjectEmcee = crosswiseProjectEmcee;
	}
	public String getCrosswiseProjectPartake() {
		return crosswiseProjectPartake;
	}
	public void setCrosswiseProjectPartake(String crosswiseProjectPartake) {
		this.crosswiseProjectPartake = crosswiseProjectPartake;
	}
	
	public String getCrosswiseProjectPrize() {
		return crosswiseProjectPrize;
	}
	public void setCrosswiseProjectPrize(String crosswiseProjectPrize) {
		this.crosswiseProjectPrize = crosswiseProjectPrize;
	}
	public String getCrosswiseProjectPrizeLevel() {
		return crosswiseProjectPrizeLevel;
	}
	public void setCrosswiseProjectPrizeLevel(String crosswiseProjectPrizeLevel) {
		this.crosswiseProjectPrizeLevel = crosswiseProjectPrizeLevel;
	}
	public String getCrosswiseProjectPrizeTime() {
		return crosswiseProjectPrizeTime;
	}
	public void setCrosswiseProjectPrizeTime(String crosswiseProjectPrizeTime) {
		this.crosswiseProjectPrizeTime = crosswiseProjectPrizeTime;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CrosswiseProject [crosswiseProjectId=").append(crosswiseProjectId)
				.append(", crosswiseProjectBianHao=").append(crosswiseProjectBianHao).append(", crosswiseProjectName=")
				.append(crosswiseProjectName).append(", crosswiseProjectSource=").append(crosswiseProjectSource)
				.append(", crosswiseProjectCompanion=").append(crosswiseProjectCompanion)
				.append(", crosswiseProjectGetMoney=").append(crosswiseProjectGetMoney)
				.append(", crosswiseProjectMoney=").append(crosswiseProjectMoney)
				.append(", crosswiseProjectAchieveDate=").append(crosswiseProjectAchieveDate)
				.append(", crosswiseProjectEmcee=").append(crosswiseProjectEmcee).append(", crosswiseProjectPartake=")
				.append(crosswiseProjectPartake).append(", crosswiseProjectPrize=").append(crosswiseProjectPrize)
				.append(", crosswiseProjectPrizeLevel=").append(crosswiseProjectPrizeLevel)
				.append(", crosswiseProjectPrizeTime=").append(crosswiseProjectPrizeTime).append(", teacherBianHao=")
				.append(teacherBianHao).append("]");
		return builder.toString();
	}
	

	
}

