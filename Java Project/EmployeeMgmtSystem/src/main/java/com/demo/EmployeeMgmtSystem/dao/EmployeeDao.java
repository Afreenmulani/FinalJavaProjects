package com.demo.EmployeeMgmtSystem.dao;

import java.util.List;

import com.demo.EmployeeMgmtSystem.entity.Employee;


public interface EmployeeDao {
	public List<Employee> getAllEmployee();

	public Employee findById(int id);
	
	public Employee save(Employee emp);
	
	public String delete(int id);
}
