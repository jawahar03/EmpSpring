package com.empspringboot.EmpSpringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.empspringboot.EmpSpringboot.config.ResponseStructure;
import com.empspringboot.EmpSpringboot.dao.EmpDao;
import com.empspringboot.EmpSpringboot.dto.Employee;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	EmpDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmp(Employee e) {
		ResponseStructure<Employee> res = new ResponseStructure<>();
		res.setData(dao.saveEmp(e));
		res.setMsg("Employee with id" + e.getEid() + " is saved");
		res.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmp(int id) {
		ResponseStructure<Employee> res = new ResponseStructure<>();
		Employee e = dao.findEmp(id);
		if(e!=null)
		{
			res.setData(e);
			res.setMsg("Employee with id" + id + " is found");
			res.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res,HttpStatus.FOUND);
		}
		else {
			res.setMsg("No book found in this id "+ id);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmp(int id) {
		ResponseStructure<Employee> res = new ResponseStructure<>();
		if(dao.findEmp(id)!=null)
		{
			res.setData(dao.deleteEmp(id));
			res.setMsg("Employee with id" + id + " is deleted");
			res.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res,HttpStatus.CREATED);
		}
		else {
			res.setMsg("No employee found in this id "+ id);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res,HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmp(int id, Employee e) {
		ResponseStructure<Employee> res = new ResponseStructure<>();
		
		if(dao.findEmp(id)!=null)
		{
			res.setData(dao.updateEmp(id, e));
			res.setMsg("Employee with id" + id + " is updated");
			res.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.CREATED);
		}
		else {
			res.setMsg("No employee found in this id "+ id);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll()
	{
		ResponseStructure<List<Employee>> res = new ResponseStructure<>();
		if(!dao.findAll().isEmpty())
		{
			res.setData(dao.findAll());
			res.setMsg("All employee details has been found");
			res.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(res,HttpStatus.CREATED);
		}
		else {
			res.setMsg("No employee found ");
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(res,HttpStatus.NOT_FOUND);
		}
		
	}
}
