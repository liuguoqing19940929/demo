package com.iss.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="manage")
public class Manage implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer manageId;
	@Column(unique = true, nullable = false)
	private String manageName;
	@Column(unique = true, nullable = false)
	private String managePassword;
	public Integer getManageId() {
		return manageId;
	}
	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
	public String getManagePassword() {
		return managePassword;
	}
	public void setManagePassword(String managePassword) {
		this.managePassword = managePassword;
	}
	
	

}

