package com.firstProject.firstProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.firstProject.firstProject.entity.MyUser;

public interface MyRepository extends JpaRepository<MyUser, String> {

	public MyUser getByEmpName(String empName);

	public MyUser getByEmpId(String empId);

	public MyUser findByEmpName(String name);
	
	public List<MyUser> findByEmpNameContains(String name);


}
