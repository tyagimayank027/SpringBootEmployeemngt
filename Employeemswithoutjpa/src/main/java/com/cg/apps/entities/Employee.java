package com.cg.apps.entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id;
	private String name;
	private String department;
	
	public Employee() {
		this("not initialized", "not initialized");
	}
	
	public Employee(String name, String department) {
		this.setName(name);
		this.setDepartment(department);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override	
	public String toString() {
		String text = "Name: "+name+" Department: "+department;
		return text;
	}
}