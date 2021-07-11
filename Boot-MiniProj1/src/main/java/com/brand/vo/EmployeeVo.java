package com.brand.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeVo implements Serializable {
	
	private String eid;
	private String ename;
	private String eaddress;
	private String emobile;
	private String esallary;
	private String edesignation;
	private String edob;
	private String ejod;
}
