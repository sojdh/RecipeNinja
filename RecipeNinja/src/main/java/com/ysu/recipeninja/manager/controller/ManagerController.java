package com.ysu.recipeninja.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController {

	@RequestMapping("Manager")
	public ModelAndView manager() {
		return new ModelAndView("manager/Main");

	}
}
