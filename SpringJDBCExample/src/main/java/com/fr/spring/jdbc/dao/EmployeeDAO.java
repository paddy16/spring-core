package com.fr.spring.jdbc.dao;

import java.util.List;

import com.fr.spring.jdbc.model.Address;
import com.fr.spring.jdbc.model.Employee;

//CRUD operations
public interface EmployeeDAO {
	
	//Create
	public void save(Employee employee);
	//Read
	public Employee getById(int id);
	//Update
	public void update(Employee employee);
	//Delete
	public void deleteById(int id);
	//Get All
	public List<Employee> getAll();
	
	public Employee findBeanByEmployeeId(int id);
	

	public Employee findByEmployeeId(int id);
	
	public int[] insertEmployeeList(List<Employee> employeeList);
	
	public int createDBObject(Address address);
}
