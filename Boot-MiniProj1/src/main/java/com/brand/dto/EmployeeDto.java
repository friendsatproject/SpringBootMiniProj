package com.brand.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDto implements Serializable {

	private Integer eid;
	private String ename;
	private String eaddress;
	private Long emobile;
	private Double esallary;
	private String edesignation;
	private String edob;
	private String ejod;
}
