package com.empspringboot.EmpSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empspringboot.EmpSpringboot.config.ResponseStructure;
import com.empspringboot.EmpSpringboot.dao.EmpDao;
import com.empspringboot.EmpSpringboot.dao.ManagerDao;
import com.empspringboot.EmpSpringboot.dto.Employee;
import com.empspringboot.EmpSpringboot.dto.Manager;

@Service
public class ManagerService 
{
	@Autowired
	ManagerDao dao;
	
	@Autowired
	EmpDao edao;
	
	
	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager m)
	{
		ResponseStructure<Manager> res = new ResponseStructure<>();
		res.setData(dao.saveManager(m));
		res.setMsg("Employee with id" + m.getId() + " is saved");
		res.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Manager>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Manager>> findManager(int id) {
		ResponseStructure<Manager> res = new ResponseStructure<>();
		Manager e = dao.findMan(id);
		if(e!=null)
		{
			res.setData(e);
			res.setMsg("Employee with id" + id + " is found");
			res.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res,HttpStatus.FOUND);
		}
		else {
			res.setMsg("No book found in this id "+ id);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Manager>> deleteManager(int id) {
		ResponseStructure<Manager> res = new ResponseStructure<>();
		if(dao.findMan(id)!=null)
		{
			res.setData(dao.deleteMan(id));
			res.setMsg("Employee with id" + id + " is deleted");
			res.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res,HttpStatus.CREATED);
		}
		else {
			res.setMsg("No employee found in this id "+ id);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res,HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> updateMan(int id, Manager e) {
		ResponseStructure<Manager> res = new ResponseStructure<>();
		
		if(dao.findMan(id)!=null)
		{
			res.setData(dao.updateMan(id, e));
			res.setMsg("Employee with id" + id + " is updated");
			res.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res, HttpStatus.CREATED);
		}
		else {
			res.setMsg("No employee found in this id "+ id);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res, HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResponseStructure<Manager>> setBookToAuthour(int manId, int empId ) {
		ResponseStructure<Manager> res = new ResponseStructure<>();
		
		Manager m = dao.findMan(manId);
		Employee e = edao.findEmp(empId);
		
		m.setEmp(e);
		
		if(dao.findMan(manId)!=null)
		{
			res.setData(dao.updateMan(manId, m));
			res.setMsg("Manager with id" + manId + " is updated");
			res.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res, HttpStatus.CREATED);
		}
		else {
			res.setMsg("No Manager found in this id "+ manId);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>>(res, HttpStatus.NOT_FOUND);
		}
		
	
	}

}
