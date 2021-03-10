package com.cg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.exceptions.*;

import com.cg.apps.dao.IEmployeeDao;
import com.cg.apps.entities.Employee;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public Employee add(String name, String department) {
		validateName(name);
		validateDepartment(department);
		Employee employee = new Employee(name, department);
		dao.add(employee);
		return employee;
	}
	
	@Override
	public Employee updateName(int id, String name){
		Employee employee=findById(id);
		employee.setName(name);
		employee=dao.update(employee);
		return employee;
	}
	
	@Override
	public Employee findById(int id) {
		validateId(id);
		Employee employee = dao.findById(id);
		return employee;
		
	}
	
	@Override
	public void removeById(int id) {
		validateId(id);
		dao.removeById(id);
		
	}
	
	@Override
	public List<Employee> findAll(){
		List<Employee> employees = dao.findAll();
		return employees;
	}
	
	public void validateId(int id) {
		if(id < 0) {
			throw new InvalidIdException("Given Id is invalid");
		}
	}
	
	public void validateName(String name) {
		if(name == null || name.isEmpty() || name.length()>10) {
			throw new InvalidEmployeeNameException("Name cannot be null or empty or less than 10");
		}
	}
	
	public void validateDepartment(String department) {
		if(department == null || department.isEmpty()) {
			throw new InvalidDepartmentException("Department cannot be null or empty");
		}
	}

}
