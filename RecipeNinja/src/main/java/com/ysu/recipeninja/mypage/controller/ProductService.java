package com.ysu.recipeninja.mypage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private List<Product> wishlist = new ArrayList<>();

    public List<Product> getWishlist() {
        return wishlist;
    }

    public void addProductToWishlist(Product product) {
        wishlist.add(product);
    }

    public void deleteProductsByIds(List<Long> ids) {
        wishlist = wishlist.stream()
                .filter(product -> !ids.contains(product.getId()))
                .collect(Collectors.toList());
    }

    // 기타 상품 관련 기능 구현
}