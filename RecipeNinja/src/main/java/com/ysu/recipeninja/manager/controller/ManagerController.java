package com.ysu.recipeninja.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController {
	
	//관리자 로그인
	@GetMapping("/ManagerLogin")
	public String ManagerLogin() {
		return "manager/ManagerLogin";
	}

	//관리자 메인
	@GetMapping("/ManagerMain")
	public String ManagerMain() {
		return "manager/ManagerMain";
	}
	
	//회원 관리
	@GetMapping("/MemberMain")
	public String MemberMain() {
		return "manager/MemberMain";
	}
	
	//탈퇴회원 관리
	@GetMapping("/S_MemberMain")
	public String S_MemberMain() {
		return "manager/S_MemberMain";
	}

	//회원 
	@GetMapping("/Member")
	public String Member() {
		return "manager/Member";
	}
	
	//탈퇴회원 
	@GetMapping("/S_Member")
	public String S_Member() {
		return "manager/S_Member";
	}
	
	//배너 관리
	@GetMapping("/BannerMain")
	public String BannerMain() {
		return "manager/BannerMain";
	}
	
	//배너
	@GetMapping("/Banner")
	public String Banner() {
		return "manager/Banner";
	}
	
	//배너 등록
	@GetMapping("/InsertBanner")
	public String InsertBanner() {
		return "manager/InsertBanner";
	}
	
	//전체 주문 관리
	@GetMapping("/OrderMain")
	public String OrderMain() {
		return "manager/OrderMain";
	}
	
	//전체 주문 관리
	@GetMapping("/Order")
	public String Order() {
		return "manager/Order";
	}
	
	//레시피 자랑
	@GetMapping("/RecipeMain")
	public String RecipeMain() {
		return "manager/RecipeMain";
	}
	
	//레시피 
	@GetMapping("/Recipe")
	public String Recipe() {
		return "manager/Recipe";
	}
	
	//공지사항 목록
	@GetMapping("/NotifiMain")
	public String NotifiMain() {
		return "manager/NotifiMain";
	}
	
	//공지사항
	@GetMapping("/Notifi")
	public String Notifi() {
		return "manager/Notifi";
	}
	
	//공지사항 등록
	@GetMapping("/InsertNotifi")
	public String InsertNotifi() {
		return "manager/InsertNotifi";
	}
	
	//자주 묻는 질문 목록
	@GetMapping("/QuestionMain")
	public String QuestionMain() {
		return "manager/QuestionMain";
	}
	
	//자주 묻는 질문
	@GetMapping("/Question")
	public String Question() {
		return "manager/Question";
	}
	
	//자주 묻는 질문 등록
	@GetMapping("/InsertQuestion")
	public String InsertQuestion() {
		return "manager/InsertQuestion";
	}
	
	//이벤트 목록
	@GetMapping("/EventMain")
	public String EventMain() {
		return "manager/EventMain";
	}
	
	//이벤트 
	@GetMapping("/Event")
	public String Event() {
		return "manager/Event";
	}
	
	//이벤트 등록
	@GetMapping("/InsertEvent")
	public String InsertEvent() {
		return "manager/InsertEvent";
	}
	
	//전체 제품 관리 목록
	@GetMapping("/ProductList")
	public String ProductList() {
		return "manager/ProductList";
	}
	
	//전체 제품
	@GetMapping("/Product")
	public String Product() {
		return "manager/Product";
	}
	
	//제품 등록
	@GetMapping("/InsertProduct")
	public String InsertProduct() {
		return "manager/InsertProduct";
	}
	
	//카테고리 관리
	@GetMapping("/Category")
	public String Category() {
		return "manager/Category";
	}
	
	//상위 카테고리 등록
	@GetMapping("/InsertTopCategory")
	public String InsertTopCategory() {
		return "manager/InsertTopCategory";
	}
	
	//상위 카테고리
	@GetMapping("/TopCategory")
	public String TopCategory() {
		return "manager/TopCategory";
	}
	
	//중위 카테고리 등록
	@GetMapping("/InsertMidCategory")
	public String InsertMidCategory() {
		return "manager/InsertMidCategory";
	}
	
	//중위 카테고리
	@GetMapping("/MidCategory")
	public String MidCategory() {
		return "manager/MidCategory";
	}
}