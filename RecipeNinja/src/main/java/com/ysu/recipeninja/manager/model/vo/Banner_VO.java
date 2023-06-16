package com.ysu.recipeninja.manager.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class Banner_VO {

	private String banner;
	private String banner_img;
	private String banner_state;
	private String banner_link;
	private String banner_sq;
	private MultipartFile banner_img_param;
	
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getBanner_img() {
		return banner_img;
	}
	public void setBanner_img(String banner_img) {
		this.banner_img = banner_img;
	}
	public String getBanner_state() {
		return banner_state;
	}
	public void setBanner_state(String banner_state) {
		this.banner_state = banner_state;
	}
	public String getBanner_link() {
		return banner_link;
	}
	public void setBanner_link(String banner_link) {
		this.banner_link = banner_link;
	}
	public String getBanner_sq() {
		return banner_sq;
	}
	public void setBanner_sq(String banner_sq) {
		this.banner_sq = banner_sq;
	}
	public MultipartFile getBanner_img_param() {
		return banner_img_param;
	}
	public void setBanner_img_param(MultipartFile banner_img_param) {
		this.banner_img_param = banner_img_param;
	}
	
	
}
