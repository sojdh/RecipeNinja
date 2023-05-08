package com.ysu.recipeninja.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	@RequestMapping("MypageMain")
	public ModelAndView mypage() {
		return new ModelAndView("mypage/MypageMain");
	}

	@RequestMapping("MypageProductLike")
	public ModelAndView mypageProductLike() {
		return new ModelAndView("mypage/MypageProductLike");
	}
	
	@RequestMapping("MypageUserModify")
	public ModelAndView mypageUserModify() {
		return new ModelAndView("mypage/MypageUserModify");
	}
	@RequestMapping("MypageUserModifyUpdate")
	public ModelAndView mypageUserModifyUpdate() {
		return new ModelAndView("mypage/MypageUserModifyUpdate");
	}
	@RequestMapping("MypageMembership")
	public ModelAndView mypageMembership() {
		return new ModelAndView("mypage/MypageMembership");
	}
	@RequestMapping("MypageNinjaPay")
	public ModelAndView mypageNinjaPay() {
		return new ModelAndView("mypage/MypageNinjaPay");
	}
	@RequestMapping("MypageDelivery")
	public ModelAndView mypageDelivery() {
		return new ModelAndView("mypage/MypageDelivery");
	}
	@RequestMapping("MypageEditDelivery")
	public ModelAndView mypageEditDelivery() {
		return new ModelAndView("mypage/MypageEditDelivery");
	}
	@RequestMapping("MypagePlusDelivery")
	public ModelAndView mypagePlusDelivery() {
		return new ModelAndView("mypage/MypagePlusDelivery");
	}
	
	@RequestMapping("MypageProductCancelReturnExchange")
	public ModelAndView mypageProductCancelReturnExchange() {
		return new ModelAndView("mypage/MypageProductCancelReturnExchange");
	}
	@RequestMapping("MypageProductOrderList")
	public ModelAndView mypageProductOrderList() {
		return new ModelAndView("mypage/MypageProductOrderList");
	}
	@RequestMapping("MypageRecipeLike")
	public ModelAndView mypageRecipeLike() {
		return new ModelAndView("mypage/MypageRecipeLike");
	}
	@RequestMapping("MypageMyRecipe")
	public ModelAndView mypageMyRecipe() {
		return new ModelAndView("mypage/MypageMyRecipe");
	}
	
	@GetMapping("/MypageProductLike")
	public String showProductLikeList() {
		return "/mypage/MypageProductLike";
	}
}
