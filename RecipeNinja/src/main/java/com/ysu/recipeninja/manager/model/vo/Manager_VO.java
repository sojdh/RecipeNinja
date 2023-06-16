package com.ysu.recipeninja.manager.model.vo;

public class Manager_VO {
	private String manager_id;
	private String manager_password;
	private String manager_login_date;
	private String manager_login_cnt;
	
	public String getManager_id() {
		return manager_id;
	}
	public String getManager_login_cnt() {
		return manager_login_cnt;
	}
	public void setManager_login_cnt(String manager_login_cnt) {
		this.manager_login_cnt = manager_login_cnt;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_password() {
		return manager_password;
	}
	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}
	public String getManager_login_date() {
		return manager_login_date;
	}
	public void setManager_login_date(String manager_login_date) {
		this.manager_login_date = manager_login_date;
	}
	
}
