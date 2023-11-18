package com.empspringboot.EmpSpringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empspringboot.EmpSpringboot.dto.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer>
{

}
