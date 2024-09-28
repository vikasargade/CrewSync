package com.jsp.EMP_System.service.imp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.EMP_System.dto.EmployeeDto;
import com.jsp.EMP_System.entity.Employee;
import com.jsp.EMP_System.exception.ResourceNotFoundException;
import com.jsp.EMP_System.mapper.EmployeeMapper;
import com.jsp.EMP_System.repository.EmployeeRepository;
import com.jsp.EMP_System.service.EmployeeSerice;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeSerice {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmlpoyeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeByID(long emloyeeID) {
		
		Employee employee = employeeRepository.findById(emloyeeID).orElseThrow(()-> new ResourceNotFoundException("Employee Not exists with given id: "+emloyeeID));
		
		return EmployeeMapper.mapToEmlpoyeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> allEmployees = employeeRepository.findAll();
		
		return allEmployees.stream().map((employee) -> EmployeeMapper.mapToEmlpoyeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(long empId, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(()-> 
						new ResourceNotFoundException("Employee Not exists with given id: "+empId));
		
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employeeDto.setEmail(employeeDto.getEmail());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		
		
		return EmployeeMapper.mapToEmlpoyeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(long empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(()-> 
		new ResourceNotFoundException("Employee Not exists with given id: "+empId));
		
		employeeRepository.deleteById(empId);
		
	}

}
