package com.ysu.recipeninja.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class MarketController {
		@RequestMapping("Market")
		public ModelAndView market() {
			return new ModelAndView("market/MarketMain");
		}
		@RequestMapping("MarketLogin")
		public ModelAndView marketLogin() {
			return new ModelAndView("market/MarketLogin");
		}
		@RequestMapping("MarketSignup")
		public ModelAndView marketSignup() {
			return new ModelAndView("market/MarketSignup");
		}


	
}
