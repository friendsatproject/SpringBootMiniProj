package com.brand.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.brand.bo.EmployeeBo;
import com.brand.dao.IEmployeeDao;
import com.brand.dto.EmployeeDto;

@Service("empService")
public final class EmployeeServiceImpl implements IEmployeeService {

	@Autowired()
	@Qualifier("empRepo")
	IEmployeeDao dao;
	
	@Override
	public List<EmployeeDto> getEmployee(String[] designation) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for(int i=0;i<designation.length;i++) {
			if(i==(designation.length)-1) 
				sb.append("'"+designation[i]+"')");
			else 
				sb.append("'"+designation[i]+"',");
		}
		List<EmployeeBo> listBo = dao.getEmployee(sb.toString());
		List<EmployeeDto> listDto = new ArrayList();
		listBo.forEach(bo->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(bo, dto);
			listDto.add(dto);
		});
		return listDto;
	}

}
