package com.cartapp.service;

import com.cartapp.model.Cart;
import com.cartapp.model.Product;

import java.util.List;

public interface ICartService {
    List<Product> getByCategory(String category);
    List<Product> getByChoice(String choice);
    Product getById(Integer productId);
    void addToCart(Integer productId);
    Cart showCart();
}
