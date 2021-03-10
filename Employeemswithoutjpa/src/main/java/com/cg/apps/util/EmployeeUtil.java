package com.cg.apps.util;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.apps.dto.*;
import com.cg.apps.entities.*;
import com.cg.apps.dto.EmployeeDetails;
import com.cg.apps.entities.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeUtil {

	    public EmployeeDetails toDetails(Employee emp){
	        EmployeeDetails details=new EmployeeDetails(emp.getId(), emp.getName(),emp.getDepartment());
	        return details;
	    }

	    public List<EmployeeDetails> toDetailsList(Collection<Employee> employees){
	        List<EmployeeDetails>desired=new ArrayList<>();
	        for (Employee employee:employees){
	            EmployeeDetails details=toDetails(employee);
	            desired.add(details);
	        }
	        return desired;

	    }


}