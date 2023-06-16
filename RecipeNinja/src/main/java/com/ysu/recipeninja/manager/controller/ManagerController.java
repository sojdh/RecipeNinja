package com.ysu.recipeninja.manager.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ysu.recipeninja.commons.FileRename;
import com.ysu.recipeninja.manager.model.service.Manager_Service;
import com.ysu.recipeninja.manager.model.vo.Banner_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryMid_VO;
import com.ysu.recipeninja.manager.model.vo.CategoryTop_VO;
import com.ysu.recipeninja.manager.model.vo.Manager_VO;
import com.ysu.recipeninja.manager.model.vo.Member_VO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ManagerController {
	@Autowired
	private Manager_Service manager_service;

	public void setManager_service(Manager_Service manager_service) {
		this.manager_service = manager_service;
	}

	@Autowired
	private FileRename filerename;

	public void setFilerename(FileRename filerename) {
		this.filerename = filerename;
	}

	// 관리자 로그인
	@GetMapping("/ManagerLogin")
	public String ManagerLogin() {
		return "manager/ManagerLogin";
	}

	// 로그인 체크
	@GetMapping("/LoginCheck")
	public String ManagerMain(@RequestParam("manager_id") String manager_id,
			@RequestParam("manager_password") String manager_password, HttpSession session, Model model) {
		int loginCheck = manager_service.managerLoginCheck(manager_id, manager_password); // id에 해당하는 관리자 정보 조회
		if (loginCheck == 0) { 
			return "manager/LoginFailed";
		} else {
			session.setAttribute("manager_id", manager_id); // 세션에 관리자 아이디 저장
			Manager_VO managerData = manager_service.managerData(manager_id);
			model.addAttribute("managerData", managerData);
			return "manager/ManagerMain";
		}
	}

	// 관리자 메인
	@GetMapping("/ManagerMain")
	public String ManagerMain(HttpServletRequest request, Model model) {
	    String manager_id = (String) request.getSession().getAttribute("manager_id");
	    Manager_VO managerData = manager_service.managerData(manager_id);
	    model.addAttribute("managerData", managerData);
	    return "manager/ManagerMain";
	}

	// 회원 관리
	@GetMapping("/MemberMain")
	public String MemberMain(Model model) {
		List<Member_VO> memberList = manager_service.memberList();
		model.addAttribute("memberList", memberList);
		return "manager/MemberMain";
	}
	
	// 회원
		@GetMapping("/Member")
		public String Member(@RequestParam("member_id") String member_id, Model model) {
			Member_VO memberData = manager_service.memberData(member_id);
			model.addAttribute("memberData", memberData);
			return "manager/Member";
		}

	// 회원 정보 업데이트
	@GetMapping("/MemberUpdate")
	public String MemberUpdate(@RequestParam("member_id") String member_id, Member_VO member_vo) {
		int result = manager_service.memberUpdate(member_vo);
		if (result > 0) {
			return "redirect:MemberMain";
		} else
			return "redirect:MemberMain";
	}
	
	// 회원 탈퇴
	@GetMapping("/MemberDelete")
	public String MemberDelete(@RequestParam("member_id") String member_id) {
		int result = manager_service.memberDelete(member_id);
		if(result > 0) {
			return "redirect:MemberMain";
		}else {
			return "manager/Memeber?memeber_id="+member_id;
		}
	}

	// 탈퇴회원 관리
	@GetMapping("/S_MemberMain")
	public String S_MemberMain() {
		return "manager/S_MemberMain";
	}

	// 탈퇴회원
	@GetMapping("/S_Member")
	public String S_Member() {
		return "manager/S_Member";
	}

	// 배너 관리
	@GetMapping("/BannerMain")
	public String BannerMain(Model model) {
		List<Banner_VO> bannerList = manager_service.bannerList();
		model.addAttribute("bannerList", bannerList);
		return "manager/BannerMain";
	}

	// 배너 업데이트
	@PostMapping("/BannerUpdate")
	public String BannerUpdate(@RequestParam("banner_img_old") String banner_img_old ,Banner_VO banner_vo) throws IOException {
		System.out.println(banner_vo.getBanner_img());
		String imagePath = "static/img/banner";
		Resource resource = new ClassPathResource(imagePath);
		String path = resource.getFile().getAbsolutePath();

		MultipartFile banner_img_param = banner_vo.getBanner_img_param();
		if (banner_img_param.getSize() == 0) {
			banner_vo.setBanner_img(banner_img_old);
			manager_service.bannerUpdate(banner_vo);
		} else {
			try {
				String banner_img = filerename.exec(path, banner_img_param.getOriginalFilename());

				banner_vo.setBanner_img(banner_img);
				int result = manager_service.bannerUpdate(banner_vo);
				if (result > 0) {
					File imageFile = new File(path + "/" + banner_img);
					banner_img_param.transferTo(imageFile);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 예외 처리 및 에러 핸들링 로직 추가
			}
		}
		return "redirect:BannerMain";
	}
	
	// 배너 삭제
	@PostMapping("/BannerDelete")
	public String BannerDelete(@RequestParam("banner") String banner) {
		int result = manager_service.bannerDelete(banner);
		if(result > 0) {
			return "manager/DeleteBanner";
		}else {
			return "manager/Banner?banner="+banner;
		}
	}

	// 배너
	@GetMapping("/Banner")
	public String Banner(@RequestParam("banner") String banner, Model model) {
		Banner_VO bannerData = manager_service.bannerData(banner);
		model.addAttribute("bannerData", bannerData);
		return "manager/Banner";
	}

	// 배너 등록 화면
	@GetMapping("/InsertBanner")
	public String InsertBanner() {
		return "manager/InsertBanner";
	}

	// 배너 등록 버튼
	@PostMapping("/InsertBannerBtn")
	public String InsertBannerBtn(@ModelAttribute("banner_vo") Banner_VO banner_vo, HttpSession session)
			throws IOException {
		String imagePath = "static/img/banner";
		Resource resource = new ClassPathResource(imagePath);
		String path = resource.getFile().getAbsolutePath();

		MultipartFile banner_img_param = banner_vo.getBanner_img_param();
		try {
			String banner_img = filerename.exec(path, banner_img_param.getOriginalFilename());
			banner_vo.setBanner_img(banner_img);
			int result = manager_service.insertBanner(banner_vo);
			if (result > 0) {
				File imageFile = new File(path + "/" + banner_img);
				banner_img_param.transferTo(imageFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 예외 처리 및 에러 핸들링 로직 추가
		}
		return "redirect:BannerMain";
	}

	// 전체 주문 관리
	@GetMapping("/OrderMain")
	public String OrderMain() {
		return "manager/OrderMain";
	}

	// 전체 주문 관리
	@GetMapping("/Order")
	public String Order() {
		return "manager/Order";
	}

	// 레시피 자랑
	@GetMapping("/RecipeMain")
	public String RecipeMain() {
		return "manager/RecipeMain";
	}

	// 레시피
	@GetMapping("/Recipe")
	public String Recipe() {
		return "manager/Recipe";
	}

	// 공지사항 목록
	@GetMapping("/NotifiMain")
	public String NotifiMain() {
		return "manager/NotifiMain";
	}

	// 공지사항
	@GetMapping("/Notifi")
	public String Notifi() {
		return "manager/Notifi";
	}

	// 공지사항 등록
	@GetMapping("/InsertNotifi")
	public String InsertNotifi() {
		return "manager/InsertNotifi";
	}

	// 자주 묻는 질문 목록
	@GetMapping("/QuestionMain")
	public String QuestionMain() {
		return "manager/QuestionMain";
	}

	// 자주 묻는 질문
	@GetMapping("/Question")
	public String Question() {
		return "manager/Question";
	}

	// 자주 묻는 질문 등록
	@GetMapping("/InsertQuestion")
	public String InsertQuestion() {
		return "manager/InsertQuestion";
	}

	// 이벤트 목록
	@GetMapping("/EventMain")
	public String EventMain() {
		return "manager/EventMain";
	}

	// 이벤트
	@GetMapping("/Event")
	public String Event() {
		return "manager/Event";
	}

	// 이벤트 등록
	@GetMapping("/InsertEvent")
	public String InsertEvent() {
		return "manager/InsertEvent";
	}

	// 전체 제품 관리 목록
	@GetMapping("/ProductList")
	public String ProductList() {
		return "manager/ProductList";
	}

	// 전체 제품
	@GetMapping("/Product")
	public String Product() {
		return "manager/Product";
	}

	// 제품 등록
	@GetMapping("/InsertProduct")
	public String InsertProduct() {
		return "manager/InsertProduct";
	}

	// 카테고리 관리
	@GetMapping("/Category")
	public String Category(Model model) {
		List<CategoryTop_VO> categoryTopList = manager_service.categoryTopList();
		List<CategoryMid_VO> categoryMidList = manager_service.categoryMidList();
		model.addAttribute("categoryTopList", categoryTopList);
		model.addAttribute("categoryMidList", categoryMidList);
		return "manager/Category";
	}

	// 상위 카테고리 등록
	@GetMapping("/InsertTopCategory")
	public String InsertTopCategory() {
		return "manager/InsertTopCategory";
	}
	
	// 상위 카테고리 등록 버튼
	@GetMapping("/InsertTopCategory_Btn")
	public String InsertTopCategory_Btn(CategoryTop_VO categoryTop_vo) {
		String topNum = manager_service.topNum().getTop_ctgy_num();
		if(topNum == null) {
			topNum = "1";
			categoryTop_vo.setTop_ctgy_num(topNum);
			manager_service.insertTopCategory(categoryTop_vo);
		}else {
			int topNum_i = Integer.parseInt(topNum)+1;
			topNum = String.valueOf(topNum_i);
			categoryTop_vo.setTop_ctgy_num(topNum);
			manager_service.insertTopCategory(categoryTop_vo);
		}
		return "redirect:Category";
	}

	// 상위 카테고리
	@GetMapping("/TopCategory")
	public String TopCategory() {
		return "manager/TopCategory";
	}

	// 중위 카테고리 등록
	@GetMapping("/InsertMidCategory")
	public String InsertMidCategory(@RequestParam("top_ctgy_name") String top_ctgy_name, Model model) {
		System.out.println(top_ctgy_name);
		CategoryMid_VO categoryMidData = manager_service.categoryMidData(top_ctgy_name);
		model.addAttribute("categoryMidData", categoryMidData);
		return "manager/InsertMidCategory";
	}

	//중분류 카테고리 등록 버튼
	@GetMapping("/InsertMidCategory_Btn")
	public String InsertMidCategory_Btn(CategoryMid_VO categoryMid_vo) {
		return "redirect:Category";
	}

	// 중위 카테고리
	@GetMapping("/MidCategory")
	public String MidCategory() {
		return "manager/MidCategory";
	}
}