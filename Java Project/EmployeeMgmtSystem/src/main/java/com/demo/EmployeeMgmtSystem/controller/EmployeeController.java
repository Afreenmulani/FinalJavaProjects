package com.demo.EmployeeMgmtSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EmployeeMgmtSystem.dao.EmployeeDao;
import com.demo.EmployeeMgmtSystem.entity.Employee;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class EmployeeController {
	
	private EmployeeDao empdao;
    @Autowired
	public EmployeeController(EmployeeDao empdao) {
		super();
		this.empdao = empdao;
	}
    @GetMapping("/")
    public List<Employee> getAllEmployee(){
    	return empdao.getAllEmployee();
    	}
	@GetMapping("/get/{id}")
	public Employee getEmp(@PathVariable int id) {
		return empdao.findById(id);
	}
	@PostMapping("/save")
	public Employee saveEmp(@RequestBody Employee emp) {
		Employee dbemp= empdao.save(emp);
		return dbemp;
	}
@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		return empdao.delete(id);
		
	}
@PutMapping("/update"+ "")
public Employee updateEmployee(@RequestBody Employee emp) {
	Employee dbemp= empdao.save(emp);
	return dbemp;

	
}
	
	

}
