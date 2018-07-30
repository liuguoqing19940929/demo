package com.iss.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="print")
public class Print implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer printId;
	//出版物名称
	@Column(nullable = false)
	private String printName;
	//出版物编码
	@Column(unique = true, nullable = false)
	private String printBianMa;
	//出版物类型
	@Column(nullable = false)
	private String printType;
	//出版时间
	@Column(nullable = false)
	private String printTime;
	//出版社
	@Column(nullable = false)
	private String printPress;
	//第一作者  相当于teacherName
	@Column(nullable = false)
	private String printFirstAuthor;
	//是否获奖
	private String printPrize;
	//获奖级别
	private String printPrizeLevel;
	//获奖时间
	private String printPrizeTime;
	//其他作者
	private String printOtherAuthor;
	@Column(nullable = false)
	private String teacherBianMa;
	public Integer getPrintId() {
		return printId;
	}
	public void setPrintId(Integer printId) {
		this.printId = printId;
	}
	public String getPrintName() {
		return printName;
	}
	public void setPrintName(String printName) {
		this.printName = printName;
	}
	public String getPrintBianMa() {
		return printBianMa;
	}
	public void setPrintBianMa(String printBianMa) {
		this.printBianMa = printBianMa;
	}
	public String getPrintType() {
		return printType;
	}
	public void setPrintType(String printType) {
		this.printType = printType;
	}
	
	public String getTeacherBianMa() {
		return teacherBianMa;
	}
	public void setTeacherBianMa(String teacherBianMa) {
		this.teacherBianMa = teacherBianMa;
	}
	public String getPrintTime() {
		return printTime;
	}
	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}
	public String getPrintPress() {
		return printPress;
	}
	public void setPrintPress(String printPress) {
		this.printPress = printPress;
	}
	public String getPrintPrize() {
		return printPrize;
	}
	public void setPrintPrize(String printPrize) {
		this.printPrize = printPrize;
	}
	public String getPrintPrizeLevel() {
		return printPrizeLevel;
	}
	public void setPrintPrizeLevel(String printPrizeLevel) {
		this.printPrizeLevel = printPrizeLevel;
	}
	public String getPrintPrizeTime() {
		return printPrizeTime;
	}
	public void setPrintPrizeTime(String printPrizeTime) {
		this.printPrizeTime = printPrizeTime;
	}
	public String getPrintFirstAuthor() {
		return printFirstAuthor;
	}
	public void setPrintFirstAuthor(String printFirstAuthor) {
		this.printFirstAuthor = printFirstAuthor;
	}
	public String getPrintOtherAuthor() {
		return printOtherAuthor;
	}
	public void setPrintOtherAuthor(String printOtherAuthor) {
		this.printOtherAuthor = printOtherAuthor;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Print [printId=").append(printId).append(", printName=").append(printName)
				.append(", printBianMa=").append(printBianMa).append(", printType=").append(printType)
				.append(", printTime=").append(printTime).append(", printPress=").append(printPress)
				.append(", printFirstAuthor=").append(printFirstAuthor).append(", printPrize=").append(printPrize)
				.append(", printPrizeLevel=").append(printPrizeLevel).append(", printPrizeTime=").append(printPrizeTime)
				.append(", printOtherAuthor=").append(printOtherAuthor).append(", teacherBianMa=").append(teacherBianMa)
				.append("]");
		return builder.toString();
	}
	
	

}

