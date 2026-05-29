package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.mapper.EmployeeMapper;
import com.msedcl.main.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponseDTO addNewEmployee(EmployeeRequestDTO employeeRequestDTO) {
		Employee employee = EmployeeMapper.mapEmployeeDTOTOEmployee(employeeRequestDTO);
		Employee savedEmployee = employeeRepository.addNewEmployee(employee);
		EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(savedEmployee);
		return employeeResponseDTO;
	}

	@Override
	public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
		Employee employee = EmployeeMapper.mapEmployeeDTOTOEmployee(employeeRequestDTO);
		Employee updatedEmployee = employeeRepository.updateEmployee(employee);
		EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(updatedEmployee);
		return employeeResponseDTO;
	}

	@Override
	public EmployeeResponseDTO getEmployeeByEmployeeId(int employeeId) {
		Employee employee = employeeRepository.getEmployeeByEmployeeId(employeeId);
		EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
		return employeeResponseDTO;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.getAllEmployees();

		List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
		for (Employee employee : employeeList) {
			EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
			employeeResponseDTOList.add(employeeResponseDTO);
		}

		return employeeResponseDTOList;
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

}
