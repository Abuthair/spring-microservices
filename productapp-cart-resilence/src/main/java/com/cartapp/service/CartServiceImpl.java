package com.cartapp.service;

import com.cartapp.model.Cart;
import com.cartapp.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    //make an api call to prodcut service
    //use an object of RestTemplate

    //port,url,responseentity->getForEntity, object-> getForObject
    private String BASEURL = "http://PRODUCT-SERVICE/product-api/products";
    @Autowired
    private RestTemplate restTemplate;

    Cart cart = new Cart();
    List<Product> products = new ArrayList<>();

    int totalcost = 0;

    //annotate the method for handling exceptions
    @CircuitBreaker(name = "CART-SERVICE", fallbackMethod = "fallbackfindProductByCat")
    @Override
    public List<Product> getByCategory(String category) {
//        String url=BASEURL.concat("/category").concat(category);
        //or we can also write as
        String url = BASEURL + "/category/" + category;
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        System.out.println(responseEntity.getStatusCode());
        List<Product> products = responseEntity.getBody();
        return products;
    }


    //fallback method
//has the same method signature similar to the calling method
//should have the exception thrown as last parameter
    public List<Product> fallbackfindProductByCat(String category,RuntimeException e) {
        return new ArrayList<>(); // return an empty list instead of exception
    }


    @CircuitBreaker(name = "CART-SERVICE", fallbackMethod = "fallbackfindProductByChoice")
    @Override
    public List<Product> getByChoice(String choice) {
        String url = BASEURL.concat("/choice/") + choice;
        List<Product> products = restTemplate.getForObject(url, List.class);
        return products;
    }
    public List<Product> fallbackfindProductByChoice(String category,RuntimeException e) {
        return new ArrayList<>();
    }

    @CircuitBreaker(name = "CART-SERVICE", fallbackMethod = "fallbackfindProductById")
    @Override
    public Product getById(Integer productId) {
        String url = BASEURL.concat("/productId/") + productId;
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity(url, Product.class);
        return responseEntity.getBody();
    }

    public Product fallbackfindProductById(Integer productId,RuntimeException e) {
        return new Product();
    }

    @Override
    public void addToCart(Integer productId) {
        String url = BASEURL.concat("/productId/") + productId;
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity(url, Product.class);
        Product product = responseEntity.getBody();
        double cost = product.getPrice();
        totalcost += cost;
        products.add(product);
        cart.setCartId(1);
        cart.setProducts(products);
        cart.setTotalcost(totalcost);
    }



    @Override
    public Cart showCart() {
        return cart;
    }

    public Cart fallbackshowCart(RuntimeException e) {
        return new Cart();
    }
}