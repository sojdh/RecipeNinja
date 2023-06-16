package com.ysu.recipeninja.manager.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysu.recipeninja.manager.model.dao.Manager_DAO;
import com.ysu.recipeninja.manager.model.vo.Banner_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryMid_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryTop_VO;
import com.ysu.recipeninja.manager.model.vo.Manager_VO;
import com.ysu.recipeninja.manager.model.vo.Member_VO;

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
	
	@Override
	public Manager_VO managerData(String manager_id){
		return manager_DAO.managerData(manager_id);
	}
	
	@Override
	public List<Member_VO> memberList() {
		return manager_DAO.memberList();
	}

	@Override
	public Member_VO memberData(String member_id) {
		return manager_DAO.memberData(member_id);
	}
	
	@Override
	public int memberUpdate(Member_VO member_vo) {
		return manager_DAO.memberUpdate(member_vo);
	}
	
	@Override
	public int memberDelete(String member_id) {
		return manager_DAO.memberDelete(member_id);
	}
	
	@Override
	public int insertBanner(Banner_VO banner_vo) {
		return manager_DAO.insertBanner(banner_vo);
	}
	
	@Override
	public List<Banner_VO> bannerList() {
		return manager_DAO.bannerList();
	}
	
	@Override
	public Banner_VO bannerData(String banner) {
		return manager_DAO.bannerData(banner);
	}
	
	@Override
	public int bannerUpdate(Banner_VO banner_vo) {
		return manager_DAO.bannerUpdate(banner_vo);
	}
	
	@Override
	public int bannerDelete(String banner) {
		return manager_DAO.bannerDelete(banner);
	}
	
	@Override
	public int insertTopCategory(CategoryTop_VO categoryTop_vo) {
		return manager_DAO.insertTopCategory(categoryTop_vo);
	}

	@Override
	public CategoryTop_VO topNum() {
		return manager_DAO.topNum();
	}
	
	@Override
	public List<CategoryTop_VO> categoryTopList() {
		return manager_DAO.categoryTopList();
	}
	
	@Override
	public List<CategoryMid_VO> categoryMidList() {
		return manager_DAO.categoryMidList();
	}
	
	@Override
	public CategoryMid_VO categoryMidData(String top_category_name) {
		return manager_DAO.categoryMidData(top_category_name);
	}
}
