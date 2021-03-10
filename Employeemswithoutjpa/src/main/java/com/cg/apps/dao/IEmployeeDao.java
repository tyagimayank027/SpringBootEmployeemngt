package com.cg.apps.dao;

import java.util.*;
import com.cg.apps.entities.*;

public interface IEmployeeDao {
	
	void add(Employee employee);
	
	Employee findById(int id);
	
	void removeById(int id);
	
	List<Employee> findAll();
	
	Employee update(Employee employee);

}