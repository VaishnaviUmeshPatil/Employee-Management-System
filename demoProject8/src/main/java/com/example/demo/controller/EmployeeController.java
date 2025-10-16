package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addemp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp)
	{
		service.addEmployee(emp);
		return new ResponseEntity<String>("Employee added",HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> EmpList=service.getAll();
		return new ResponseEntity<List<Employee>>(EmpList,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		service.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted Succesfully!",HttpStatus.OK);
	}
	
	@GetMapping("/getOneEmp/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable int id){
		Employee emp = service.getOneEmployee(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	
}
