package com.brand.dao;

import java.util.List;

import com.brand.bo.EmployeeBo;

public interface IEmployeeDao {

	public List<EmployeeBo> getEmployee(String condition) throws Exception;
}
