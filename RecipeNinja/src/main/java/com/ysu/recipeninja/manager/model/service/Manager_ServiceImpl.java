package com.ysu.recipeninja.manager.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysu.recipeninja.manager.model.dao.Manager_DAO;

@Service
public class Manager_ServiceImpl implements Manager_Service{
	
	@Autowired
    private Manager_DAO manager_DAO;
	
	public void setManager_DAO(Manager_DAO manager_DAO) {
		this.manager_DAO = manager_DAO;
	}

	@Override
	public int managerLoginCheck(String manager_id, String manager_password) {
		
		return manager_DAO.managerLoginCheck(manager_id, manager_password);
	}
}
