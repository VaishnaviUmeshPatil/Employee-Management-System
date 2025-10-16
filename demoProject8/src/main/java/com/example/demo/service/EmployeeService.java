package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Integer addEmployee(Employee e);

	List<Employee> getAll();

	void deleteEmployee(Integer id);

	Employee getOneEmployee(Integer id);

	
	
}
