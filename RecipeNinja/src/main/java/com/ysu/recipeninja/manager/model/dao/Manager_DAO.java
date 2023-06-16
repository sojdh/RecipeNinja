package com.ysu.recipeninja.manager.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ysu.recipeninja.manager.model.vo.Banner_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryMid_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryTop_VO;
import com.ysu.recipeninja.manager.model.vo.Manager_VO;
import com.ysu.recipeninja.manager.model.vo.Member_VO;

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
		
		sqlsessiontemplate.update("manager.cnt", loginCheck);
		return sqlsessiontemplate.selectOne("manager.getManagerID", loginCheck);
	}
	
	public Manager_VO managerData(String manager_id){
		return sqlsessiontemplate.selectOne("manager.getManagerData", manager_id);
	}
	
	public List<Member_VO> memberList() {
		return sqlsessiontemplate.selectList("manager.getMemberList");
	}
	
	public Member_VO memberData(String member_id) {
		return sqlsessiontemplate.selectOne("manager.getMemberData", member_id);
	}
	
	public int memberUpdate(Member_VO member_vo) {
		return sqlsessiontemplate.update("manager.MemberUpdate", member_vo);
	}
	
	public int memberDelete(String member_id) {
	    sqlsessiontemplate.delete("manager.PointDelete", member_id);
	    sqlsessiontemplate.delete("manager.MemberRankDelete", member_id);
	    return sqlsessiontemplate.delete("manager.MemberDelete", member_id);
	}
	
	public int insertBanner(Banner_VO banner_vo) {
		return sqlsessiontemplate.insert("manager.insertBanner", banner_vo);
	}
	
	public List<Banner_VO> bannerList() {
		return sqlsessiontemplate.selectList("manager.getBannerList");
	}
	
	public Banner_VO bannerData(String banner) {
		return sqlsessiontemplate.selectOne("manager.getBannerData", banner);
	}
	
	public int bannerUpdate(Banner_VO banner_vo) {
		return sqlsessiontemplate.update("manager.bannerUpdate", banner_vo);
	}
	
	public int bannerDelete(String banner) {
		return sqlsessiontemplate.delete("manager.bannerDelete", banner);
	}
	
	public int insertTopCategory(CategoryTop_VO categoryTop_vo) {
		return sqlsessiontemplate.insert("manager.insertTopCategory", categoryTop_vo);
	}
	
	public CategoryTop_VO topNum() {
		return sqlsessiontemplate.selectOne("manager.topNum");
	}
	
	public List<CategoryTop_VO> categoryTopList() {
		return sqlsessiontemplate.selectList("manager.categoryTopList");
	}
	
	public List<CategoryMid_VO> categoryMidList() {
		return sqlsessiontemplate.selectList("manager.categoryMidList");
	}
	
	public CategoryMid_VO categoryMidData(String top_category_name) {
		return sqlsessiontemplate.selectOne("manager.categoryMidData", top_category_name);
	}
}
