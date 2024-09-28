package com.jsp.EMP_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.EMP_System.dto.EmployeeDto;
import com.jsp.EMP_System.service.EmployeeSerice;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeSerice employeeSerice;
	
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto savedDto = employeeSerice.createEmployee(employeeDto);
		return new ResponseEntity<>(savedDto,HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<EmployeeDto>> getAllEmployee()
	{
		List<EmployeeDto> employees  = employeeSerice.getAllEmployee();
		return 	ResponseEntity.ok(employees);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id") long empID)
	{
		EmployeeDto empFromDb = employeeSerice.getEmployeeByID(empID);
		return ResponseEntity.ok(empFromDb);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long empId, @RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto updatedEmployee = employeeSerice.updateEmployee(empId, employeeDto);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable("id") long empId)
	{
		employeeSerice.deleteEmployee(empId);
		return ResponseEntity.ok("Employee Deleted Sucesfully");
	}
	

}
