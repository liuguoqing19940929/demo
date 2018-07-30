package com.iss.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teacherId;
	@Column(nullable = false)
	private String teacherName;
	@Column(unique = true, nullable = false)
	private String teacherBianHao;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String birthday;
	@Column(nullable = false)
	private String teacherPassword;
	private String address;
	private String phone;
	/*private String role;*/
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getTeacherBianHao() {
		return teacherBianHao;
	}
	public void setTeacherBianHao(String teacherBianHao) {
		this.teacherBianHao = teacherBianHao;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	/*public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}*/
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Teacher() {
		super();
	}
	
	public Teacher(Integer teacherId, String teacherName, String teacherBianHao, String gender, String birthday,
			String teacherPassword, String address, String phone) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherBianHao = teacherBianHao;
		this.gender = gender;
		this.birthday = birthday;
		this.teacherPassword = teacherPassword;
		this.address = address;
		this.phone = phone;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Teacher [teacherId=").append(teacherId).append(", teacherName=").append(teacherName)
				.append(", teacherBianHao=").append(teacherBianHao).append(", gender=").append(gender)
				.append(", birthday=").append(birthday).append(", teacherPassword=").append(teacherPassword)
				.append(", address=").append(address).append(", phone=").append(phone).append("]");
		return builder.toString();
	}
	

}

