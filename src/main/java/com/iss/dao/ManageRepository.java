package com.iss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iss.pojo.Manage;
@Repository
public interface ManageRepository extends JpaRepository<Manage, Integer> {
	
	Manage findByManageNameAndManagePassword(String manageName, String managePassword);

}

