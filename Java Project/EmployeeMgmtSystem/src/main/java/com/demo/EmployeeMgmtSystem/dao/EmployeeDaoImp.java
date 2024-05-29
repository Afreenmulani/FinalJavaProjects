package com.demo.EmployeeMgmtSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.EmployeeMgmtSystem.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class EmployeeDaoImp implements EmployeeDao{

	private EntityManager entitymanager;

	@Autowired
	public EmployeeDaoImp(EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}

	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> emp = entitymanager.createQuery("From Employee", Employee.class);
		List<Employee> resultList = emp.getResultList();
		return resultList;
	
	}

	@Override
	public Employee findById(int id) {
		return entitymanager.find(Employee.class, id);
	}

	@Override
	@Transactional
	public Employee save(Employee emp) {
		Employee dbemp= entitymanager.merge(emp);
		return dbemp;
	}

	@Override
	@Transactional
	public String delete(int id) {
		Employee dbemp= entitymanager.find(Employee.class, id);
		entitymanager.remove(dbemp);
		return "Deleted Id:"+id;
	}

}
