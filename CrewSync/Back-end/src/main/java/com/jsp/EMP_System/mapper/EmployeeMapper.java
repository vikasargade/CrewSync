package com.jsp.EMP_System.mapper;

import com.jsp.EMP_System.dto.EmployeeDto;
import com.jsp.EMP_System.entity.Employee;

public class EmployeeMapper {
	
	
	public static EmployeeDto mapToEmlpoyeeDto(Employee employee)
	{
		return new EmployeeDto(
				
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto)
	{
		return new Employee(
				
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				
				);
	}

}
