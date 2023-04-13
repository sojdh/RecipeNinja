package com.ysu.recipeninja.mypage.controller;

public class Product {

    private Long id;
    private String name;
    private int price;

    public Product(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

    // getter, setter 메소드 생략
}