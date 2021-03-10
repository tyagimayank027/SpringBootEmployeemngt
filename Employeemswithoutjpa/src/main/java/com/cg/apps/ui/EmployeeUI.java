package com.cg.apps.ui;
import java.util.*;
import com.cg.apps.entities.Employee;
import com.cg.apps.exceptions.InvalidIdException;
import com.cg.apps.exceptions.InvalidDepartmentException;
import com.cg.apps.service.IEmployeeService;
import com.cg.apps.service.EmployeeServiceImpl;
import com.cg.apps.exceptions.InvalidEmployeeNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUI {

	@Autowired
	private IEmployeeService service;

	public void start() {

		try {
			Employee mayank = service.add("Mayank", "Developer");
			display(mayank);
			Employee naman = service.add("Naman", "Tester");
			display(naman);
			Employee gautam = service.add("Gautam", "Support");
			display(gautam);

			List<Employee> list = service.findAll();
			displayAll(list);

		} catch (InvalidIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidEmployeeNameException e) {
			System.out.println(e.getMessage());
		} catch (InvalidDepartmentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

	}

	public void display(Employee employee) {
		System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getDepartment());
	}

	public void displayAll(Collection<Employee> employees) {
		for (Employee employee : employees) {
			display(employee);
		}
	}

}
