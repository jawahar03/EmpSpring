package com.empspringboot.EmpSpringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empspringboot.EmpSpringboot.dto.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> 
{

}
