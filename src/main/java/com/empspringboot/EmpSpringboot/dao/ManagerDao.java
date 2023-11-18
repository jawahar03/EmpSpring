package com.empspringboot.EmpSpringboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empspringboot.EmpSpringboot.dto.Employee;
import com.empspringboot.EmpSpringboot.dto.Manager;
import com.empspringboot.EmpSpringboot.repo.ManagerRepo;

@Repository
public class ManagerDao 
{
	@Autowired
	ManagerRepo repo;
	
	public Manager saveManager(Manager m)
	{
		return repo.save(m);
	}
	
	public Manager findMan(int id) {
		Optional<Manager> emp = repo.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

	public Manager deleteMan(int id) {
		Manager e = findMan(id);
		if (e != null) {
			repo.delete(e);
			return e;
		}
		return null;
	}

	public Manager updateMan(int id, Manager e) {
		Manager e1 = findMan(id);
		if (e1 != null) {
			if (e.getContact() > 0) {
				e.setContact(e1.getContact());
			}
			if (e.getName() == null) {
				e.setName(e1.getName());
			}
			if (e.getEmp() == null) {
				e.setEmp(e1.getEmp());
			}
			e.setId(id);
			return repo.save(e);
		}
		return null;
	}
}
