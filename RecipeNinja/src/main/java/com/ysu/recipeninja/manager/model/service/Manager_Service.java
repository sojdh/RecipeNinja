package com.ysu.recipeninja.manager.model.service;

import java.util.List;

import com.ysu.recipeninja.manager.model.vo.Banner_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryMid_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryTop_VO;
import com.ysu.recipeninja.manager.model.vo.Manager_VO;
import com.ysu.recipeninja.manager.model.vo.Member_VO;

public interface Manager_Service {
	int managerLoginCheck(String manager_id, String manager_password);
	Manager_VO managerData(String manager_id);
	
	List<Member_VO> memberList();
	Member_VO memberData(String member_id);
	int memberUpdate(Member_VO member_vo);
	int memberDelete(String member_id);
	
	int insertBanner(Banner_VO banner_vo);
	List<Banner_VO> bannerList();
	Banner_VO bannerData(String banner);
	int bannerUpdate(Banner_VO banner_vo);
	int bannerDelete(String banner);
	
	int insertTopCategory(CategoryTop_VO categoryTop_vo);
	CategoryTop_VO topNum();
	List<CategoryTop_VO> categoryTopList();
	List<CategoryMid_VO> categoryMidList();
	CategoryMid_VO categoryMidData (String top_category_name);
}
