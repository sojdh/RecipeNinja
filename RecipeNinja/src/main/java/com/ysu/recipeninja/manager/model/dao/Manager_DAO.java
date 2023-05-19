package com.ysu.recipeninja.manager.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Manager_DAO {
	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;

	public void setSqlsessiontemplate(SqlSessionTemplate sqlsessiontemplate) {
		this.sqlsessiontemplate = sqlsessiontemplate;
	}
	
	public int managerLoginCheck(String manager_id, String manager_password) {
		Map<String, String> loginCheck = new HashMap<String, String>();
		loginCheck.put("manager_id", manager_id);
		loginCheck.put("manager_password", manager_password);
		
		return sqlsessiontemplate.selectOne("manager.getManagerID", loginCheck);
	}
}
