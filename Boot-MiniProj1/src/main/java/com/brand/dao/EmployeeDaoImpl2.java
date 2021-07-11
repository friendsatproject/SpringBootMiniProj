package com.brand.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.brand.bo.EmployeeBo;

@Repository("repo")
public final class EmployeeDaoImpl2 implements IEmployeeDao {

	@Override
	public List<EmployeeBo> getEmployee(String condition) throws Exception {
		
		EmployeeBo bo = new EmployeeBo();
		bo.setEid(01);
		bo.setEname("Karan J");
		bo.setEaddress("Latur");
		List<EmployeeBo> listBo = new ArrayList<>();
		listBo.add(bo);
		return listBo;
	}

}
