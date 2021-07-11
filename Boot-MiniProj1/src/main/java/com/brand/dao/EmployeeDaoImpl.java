package com.brand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brand.bo.EmployeeBo;

@Repository("empRepo")
public final class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	DataSource ds;

	private static final String EMP_QUERY = "SELECT  * FROM EMPLOYEE WHERE ";

	@Override
	public List<EmployeeBo> getEmployee(String condition) throws Exception {
		EmployeeBo bo ;
		List<EmployeeBo> list = new ArrayList<>();
		
		try (Connection con = ds.getConnection(); Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(EMP_QUERY+condition+" ORDER BY ENAME");
			
			while(rs.next()) {
				bo=new EmployeeBo();
				bo.setEid(rs.getInt("eid"));
				bo.setEname(rs.getString("ename"));
				bo.setEaddress(rs.getString("eaddress"));
				bo.setEmobile(rs.getLong("emobile"));
				bo.setEsallary(rs.getDouble("esallary"));
				bo.setEdesignation(rs.getString("edesignation"));
				bo.setEdob(rs.getString("edob"));
				bo.setEjod(rs.getString("ejod"));
				
				list.add(bo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}
