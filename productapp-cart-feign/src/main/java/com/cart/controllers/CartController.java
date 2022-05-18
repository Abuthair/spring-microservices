package com.cart.controllers;

import com.cart.model.Cart;
import com.cart.model.Product;
import com.cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart-api")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @GetMapping("/cart/category/{category}")
    List<Product> getByCategory(@PathVariable("category") String category){
        return iCartService.getByCategory(category);
    }
    @GetMapping("/cart/choice/{choice}")
    List<Product> getByChoice(@PathVariable("choice") String choice){
           return iCartService.getByChoice(choice);
    }
@GetMapping("/cart/productId/{productId}")
    ResponseEntity<Product> getById(@PathVariable("productId") Integer productId){
        Product product =iCartService.getById(productId);
        return ResponseEntity.ok(product);
    }
    Cart cart = new Cart();
    List<Product> productList= new ArrayList<>();
    int totalcost;
    @GetMapping("/cart/add-to-cart/{productId}")
   ResponseEntity<String> addToCart(@PathVariable("productId") Integer productId){
       Product product =iCartService.getById(productId);
       double cost =product.getPrice();
       totalcost+=cost;
       productList.add(product);
       cart.setCartId(1);
       cart.setProducts(productList);
       cart.setTotalcost(totalcost);
       return ResponseEntity.ok("ADDED TO CART");
    }
   @GetMapping("/cart/show-cart")
    ResponseEntity<Cart> showCart(){

        return ResponseEntity.ok(cart);
    //}
}
}
