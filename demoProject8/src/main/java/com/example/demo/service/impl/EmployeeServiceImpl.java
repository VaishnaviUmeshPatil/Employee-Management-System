package com.example.demo.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepo repo;
	
	
	@Override
	public Integer addEmployee(Employee e) {
		Integer empId = repo.save(e).getEmpId();
		return empId;
		
	}

	
	@Override
	public List<Employee> getAll() {
		return repo.findAll();
	}

	
	@Override
	public void deleteEmployee(Integer id) {
		Employee emp = getOneEmployee(id);
		repo.delete(emp);	
	}

	
	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> e = repo.findById(id);
     	Employee emp = e.orElseThrow(()-> new EmployeeNotFoundException("Employee Not Exist"));
        return emp;
		
	}



	
	
}
