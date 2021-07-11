package com.brand.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.brand.dto.EmployeeDto;
import com.brand.service.IEmployeeService;
import com.brand.vo.EmployeeVo;

@Controller("controller")
public final class EmployeeController {

	@Autowired
	@Qualifier("empService")
	IEmployeeService service;

	public List<EmployeeVo> getEmployee(String[] designation) throws Exception {

		List<EmployeeDto> listDto = service.getEmployee(designation);
		List<EmployeeVo> listVo = new ArrayList<>();

		listDto.forEach(dto -> {
			EmployeeVo vo = new EmployeeVo();
			BeanUtils.copyProperties(dto, vo);
			vo.setEid(String.valueOf(dto.getEid()));
			vo.setEmobile(String.valueOf(dto.getEmobile()));
			vo.setEsallary(String.valueOf(dto.getEsallary()));
			listVo.add(vo);
		});
		return listVo;
	}
}
