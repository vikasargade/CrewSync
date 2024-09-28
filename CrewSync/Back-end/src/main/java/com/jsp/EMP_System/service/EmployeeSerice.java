package com.jsp.EMP_System.service;

import java.util.List;

import com.jsp.EMP_System.dto.EmployeeDto;

public interface EmployeeSerice {
	
	EmployeeDto createEmployee (EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeByID(long emloyeeID);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee(long empId, EmployeeDto employeeDto);
	
	void deleteEmployee(long empId);

}
