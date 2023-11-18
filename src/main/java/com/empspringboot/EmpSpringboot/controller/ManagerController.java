package com.empspringboot.EmpSpringboot.controller;


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
import com.empspringboot.EmpSpringboot.dto.Manager;
import com.empspringboot.EmpSpringboot.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController 
{
	@Autowired
	ManagerService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Manager>> saveMan( @RequestBody Manager e)
	{
		return ser.saveManager(e);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Manager>> findMan(@RequestParam int id)
	{
		return ser.findManager(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Manager>> deleteMan(@RequestParam int  id)
	{
		return ser.deleteManager(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Manager>> updateMan( @RequestParam int id ,@RequestBody Manager e)
	{
		return ser.updateMan(id, e);
	}
	
	@PutMapping("/assign")
	public ResponseEntity<ResponseStructure<Manager>> assignEmp( @RequestParam int empId ,@RequestParam int manId)
	{
		return ser.setBookToAuthour(manId, empId);
	}
	
	

	
}
