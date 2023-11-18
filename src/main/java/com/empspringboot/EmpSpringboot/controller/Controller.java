package com.empspringboot.EmpSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empspringboot.EmpSpringboot.config.ResponseStructure;
import com.empspringboot.EmpSpringboot.dto.Employee;
import com.empspringboot.EmpSpringboot.service.Service;

@RestController
@RequestMapping("/emp")
public class Controller {

	@Autowired
	Service ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> saveEmp( @RequestBody Employee e)
	{
		return ser.saveEmp(e);
		
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Employee>> findEmp(@RequestParam int id)
	{
		return ser.findEmp(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Employee>> deleteEmp(@RequestParam int  id)
	{
		return ser.deleteEmp(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Employee>> updateEmp( @RequestParam int id ,@RequestBody Employee e)
	{
		return ser.updateEmp(id, e);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Employee>>>  findAll()
	{
		return ser.findAll();
	}
	
}
