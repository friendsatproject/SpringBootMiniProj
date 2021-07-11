package com.brand.service;

import java.util.List;

import com.brand.dto.EmployeeDto;

public interface IEmployeeService {

	public List<EmployeeDto> getEmployee(String[] designation)throws Exception;
}
