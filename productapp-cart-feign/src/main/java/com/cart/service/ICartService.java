package com.cart.service;

import com.cart.model.Cart;
import com.cart.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "PRODUCT-SERVICE")
public interface ICartService {
    @GetMapping("/product-api/products/category/{category}")
List<Product> getByCategory(@PathVariable("category") String category);
    @GetMapping("/product-api/products/choice/{choice}")
List<Product> getByChoice(@PathVariable("choice") String choice);
    @GetMapping("/product-api/products/productId/{productId}")
    Product getById(@PathVariable("productId") Integer productId);


}
//number,name,price , total price
