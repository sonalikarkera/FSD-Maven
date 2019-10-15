package com.mycompany.hibernatecrudedemo.dao;

import java.util.List;

import com.mycompany.hibernatecrudedemo.shared.SharedEmployee;

public interface EmployeeDAO {
	
	public void createEmployee(SharedEmployee sEmployee);
	public List<SharedEmployee> getAllEmployee();
public SharedEmployee findbyid(int id);
public void findbyCustomid(String customid);
public void deleteEmployee(int id);
public void updateEmployee(int idd);
}