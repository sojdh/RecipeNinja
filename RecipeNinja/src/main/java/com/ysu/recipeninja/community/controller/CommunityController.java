package com.ysu.recipeninja.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class CommunityController {
		@RequestMapping("Community")
		public ModelAndView community() {
			return new ModelAndView("community/RecipeBoast");
		}

	
}
