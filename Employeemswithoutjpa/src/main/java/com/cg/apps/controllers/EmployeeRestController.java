package com.cg.apps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.entities.*;
import com.cg.apps.service.*;

@RequestMapping("/employee")
@RestController
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping(value = "byId/{id}")
	public Employee fetchEmpoyee(@PathVariable("id") int employeeId) {
		Employee employee = service.findById(employeeId);
		return employee;
	}
	
	@GetMapping
	public List<Employee> fetchAllEmployee(){
		List<Employee> list = service.findAll();
		return list;
	}
	
	@PostMapping("/add")
    public String addEmployee(@RequestBody Employee requestData) {
        Employee create = service.add(requestData.getName(), requestData.getDepartment());
        return "Created employee with id=" + create.getId();
    }
	
	@PutMapping("/changename")
    public Employee changeName(@RequestBody Employee employee) {
        employee = service.updateName(employee.getId(), employee.getName());
        return employee;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Employee employee){
        service.removeById(employee.getId());
        return "Employee of id is deleted="+employee.getId();
    }
	
	

}