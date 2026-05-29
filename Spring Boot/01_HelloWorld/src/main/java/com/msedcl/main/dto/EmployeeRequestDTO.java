package com.msedcl.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class EmployeeRequestDTO {
	private int employeeId;
	private String name;
	private double salary;

}
