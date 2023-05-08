package com.ysu.recipeninja.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public String showWishlist(Model model) {
		List<Product> wishlist = productService.getWishlist();
		model.addAttribute("wishlist", wishlist);
		return "wishlist";
	}

	@PostMapping("/deleteSelected")
	public String deleteSelectedProducts(@RequestParam(value = "selected", required = false) List<Long> selectedIds) {
		if (selectedIds != null) {
			productService.deleteProductsByIds(selectedIds);
		}
		return "redirect:/wishlist";
	}
}
