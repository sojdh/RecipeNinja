package com.ysu.recipeninja.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ysu.recipeninja.market.model.service.Market_Service;
import com.ysu.recipeninja.market.model.vo.Market_VO;

@Controller
public class MarketController {
	private Market_Service market_Service;

	@Autowired
	public void setMarket_service(Market_Service market_Service) {
		this.market_Service = market_Service;
	}

	@GetMapping("/Market")
    public String market(Model model) {
        Market_VO banner = market_Service.getBannerByBanner("1");  // assuming you want to fetch the banner with ID 1
        model.addAttribute("banner", banner);
        return "market/MarketMain";  // return to market.html
    }

	@GetMapping("/ProductSubPage")
	public String ProductSubPage() {
		return "market/ProductSubPage";
	}

	@GetMapping("/MarketLogin")
	public String MarketLogin() {
		return "market/MarketLogin";
	}

	@GetMapping("/MarketSignup")
	public String MarketSignup() {
		return "market/MarketSignup";
	}

	@GetMapping("/MarketProductFresh")
	public String MarketProductFresh() {
		return "market/MarketProductFresh";
	}

	@GetMapping("/MarketOrderPayment")
	public String MarketOrderPayment() {
		return "market/MarketOrderPayment";
	}

	@GetMapping("/MarketCart")
	public String MarketCart() {
		return "market/MarketCart";
	}

}
