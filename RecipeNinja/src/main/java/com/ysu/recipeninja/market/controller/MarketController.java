package com.ysu.recipeninja.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class MarketController {
		@RequestMapping("Market")
		public ModelAndView market() {
			return new ModelAndView("market/MarketMain");
	
	
		}
<<<<<<< HEAD
	@Controller
	public class ProductSubPage{
		@RequestMapping("ProductSubPage")
		public ModelAndView productsubpage() {
			return new ModelAndView("market/ProductSubPage");
		}
	}
=======
		@RequestMapping("MarketLogin")
		public ModelAndView marketLogin() {
			return new ModelAndView("market/MarketLogin");
		}
		@RequestMapping("MarketSignup")
		public ModelAndView marketSignup() {
			return new ModelAndView("market/MarketSignup");
		}


>>>>>>> c0f10a2fb390f7fba10a3a47ab7a5306543d0df1
	
}
