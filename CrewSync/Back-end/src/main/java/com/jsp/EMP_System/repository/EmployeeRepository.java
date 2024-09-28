package com.jsp.EMP_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.EMP_System.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
