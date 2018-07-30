package com.iss.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "paper")
public class Paper implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paperId;
	//论文名称
	private String paperName;
	//论文编码
	private String paperBianMa;
	//论文水平
	private String paperLevel;
	//论文发表时间
	private String paperTime;
	//刊物名称
	private String periodicalName;
	//相当于teacherName
	private String paperAuthor;
	//是否获奖
	private String paperPrize;
	//或将级别
	private String paperPrizeLevel;
	//获奖时间
	private String paperPrizeTime;
	private String teacherBianMa;
	public Integer getPaperId() {
		return paperId;
	}
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPaperBianMa() {
		return paperBianMa;
	}
	public void setPaperBianMa(String paperBianMa) {
		this.paperBianMa = paperBianMa;
	}
	public String getPaperLevel() {
		return paperLevel;
	}
	public void setPaperLevel(String paperLevel) {
		this.paperLevel = paperLevel;
	}
	public String getPeriodicalName() {
		return periodicalName;
	}
	public void setPeriodicalName(String periodicalName) {
		this.periodicalName = periodicalName;
	}
	public String getPaperAuthor() {
		return paperAuthor;
	}
	public void setPaperAuthor(String paperAuthor) {
		this.paperAuthor = paperAuthor;
	}
	public String getPaperPrize() {
		return paperPrize;
	}
	public void setPaperPrize(String paperPrize) {
		this.paperPrize = paperPrize;
	}
	public String getPaperPrizeLevel() {
		return paperPrizeLevel;
	}
	public void setPaperPrizeLevel(String paperPrizeLevel) {
		this.paperPrizeLevel = paperPrizeLevel;
	}
	public String getPaperPrizeTime() {
		return paperPrizeTime;
	}
	public void setPaperPrizeTime(String paperPrizeTime) {
		this.paperPrizeTime = paperPrizeTime;
	}
	public String getTeacherBianMa() {
		return teacherBianMa;
	}
	public void setTeacherBianMa(String teacherBianMa) {
		this.teacherBianMa = teacherBianMa;
	}
	public String getPaperTime() {
		return paperTime;
	}
	public void setPaperTime(String paperTime) {
		this.paperTime = paperTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paper [paperId=").append(paperId).append(", paperName=").append(paperName)
				.append(", paperBianMa=").append(paperBianMa).append(", paperLevel=").append(paperLevel)
				.append(", paperTime=").append(paperTime).append(", periodicalName=").append(periodicalName)
				.append(", paperAuthor=").append(paperAuthor).append(", paperPrize=").append(paperPrize)
				.append(", paperPrizeLevel=").append(paperPrizeLevel).append(", paperPrizeTime=").append(paperPrizeTime)
				.append(", teacherBianMa=").append(teacherBianMa).append("]");
		return builder.toString();
	}
	
	

}

