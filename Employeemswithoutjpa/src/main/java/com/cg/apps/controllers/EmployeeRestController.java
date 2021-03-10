package com.cg.apps.controllers;

import java.util.*;
import com.cg.apps.util.EmployeeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.apps.service.*;
import com.cg.apps.dto.*;
import com.cg.apps.entities.*;
import org.springframework.http.HttpStatus;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	

    @Autowired
    private EmployeeUtil util;

   
    @GetMapping(value = "/byid/{id}")
    public EmployeeDetails fetchEmployee(@PathVariable("id") Integer employeeId) {
    	
        Employee employee  = service.findById(employeeId);
        
        EmployeeDetails details=util.toDetails(employee);
        return details;
    }


   
    @GetMapping
    public List<EmployeeDetails> allEmployees() {
    	
        List<Employee> list = service.findAll();
        
        List<EmployeeDetails>desired=util.toDetailsList(list);
        
        return desired;
    }

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public String addEmployee(@RequestBody CreateEmployeeRequest requestData) {
    	
        Employee created = service.add(requestData.getName(), requestData.getDepartment());
        
        return "created employee with id=" + created.getId();
    }

    @PutMapping("/changename")
    public EmployeeDetails changeName(@RequestBody ChangeNameRequest requestData) {
    	
        Employee employee = service.updateName(requestData.getId(), requestData.getName());
        
        EmployeeDetails desired = util.toDetails(employee);
        
        return desired;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteEmployeeRequest requestData){
    	
        service.removeById(requestData.getId());
        
        return "employee deleted for id="+requestData.getId();
    }


	

}