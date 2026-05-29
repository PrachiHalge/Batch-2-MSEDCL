package com.msedcl.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.ResponseDTO;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.service.EmployeeService;

@RestController
@RequestMapping("employeecrudapi")
public class EmployeeCRUDController {

	private EmployeeService employeeService;

	public EmployeeCRUDController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// URL = http://localhost:8080/employeecurdapi/employees/101
	// METHOD = DELETE

	@DeleteMapping("employees/{employeeId}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int employeeId) {
		boolean result = employeeService.deleteEmployeeByEmployeeId(employeeId);
		if (result)
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO("Employee with employeeId =" + employeeId + " Deleted successfully"));
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(
					"Failed to delete Employee with employeeId =" + employeeId + " , NOT FOUND/Invalid EmployeeId"));
	}

//	// URL = http://localhost:8080/employeecrudapi/employees/employee
//	// METHOD = PUT
//	@PutMapping("employees/employee")
//	public Employee updateEmployee(@RequestBody Employee employee) {
//		return employeeService.updateEmployee(employee);
//	}
//
//	// URL = http://localhost:8080/employeecrudapi/employees/employee
//	// METHOD = POST
//	@PostMapping("employees/employee")
//	public Employee addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
//		System.out.println(employeeRequestDTO);
//		return employeeService.addNewEmployee(employeeRequestDTO);
//	}
//
//	// URL = http://localhost:8080/employeecurdapi/employees/101
//	// METHOD = GET
//	@GetMapping("employees/{employeeId}")
//	public Employee getSingleEmployee(@PathVariable int employeeId) {
//		return employeeService.getEmployeeByEmployeeId(employeeId);
//	}
//
//	// URL = http://localhost:8080/employeecrudapi/employees
//	// METHOD = GET
//	@GetMapping("employees")
//	public List<Employee> allEmployees() {
//		return employeeService.getAllEmployees();
//	}

}
