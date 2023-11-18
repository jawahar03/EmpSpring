package com.empspringboot.EmpSpringboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empspringboot.EmpSpringboot.dto.Employee;
import com.empspringboot.EmpSpringboot.repo.EmpRepo;

@Repository
public class EmpDao {
	@Autowired
	EmpRepo repo;

	public Employee saveEmp(Employee e) {
		return repo.save(e);
	}

	public Employee findEmp(int id) {
		Optional<Employee> emp = repo.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

	public Employee deleteEmp(int id) {
		Employee e = findEmp(id);
		if (e != null) {
			repo.delete(e);
			return e;
		}
		return null;
	}

	public Employee updateEmp(int id, Employee e) {
		Employee e1 = findEmp(id);
		if (e1 != null) {
			if (e.getName() == null) {
				e.setName(e1.getName());
			}
			if (e.getContact() > 0) {
				e.setContact(e1.getContact());
			}
			if (e.getCity() == null) {
				e.setCity(e1.getCity());
			}
			e.setEid(id);
			return repo.save(e);
		}
		return null;
	}

	public List<Employee> findAll() {
		return repo.findAll();
	}

}
