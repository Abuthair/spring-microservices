package com.productapp.controllers;

import com.productapp.model.Product;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/product-api")
@RestController
@Profile("prod")
public class ProductController {

    IProductService iProductService;
       @Autowired
    public void setiProductService(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    private String message;
@Value("${message}")
    public void setMessage(String message) {
        this.message = message;
    }

    @GetMapping("/greet")
    public String greet(){
        return message;
    }


    @PostMapping("/products")
   ResponseEntity<Void>  addProduct(@RequestBody  Product product){
        iProductService.addProduct(product);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity ;
    }
    @PutMapping("/products")
    ResponseEntity<Void> updateProduct(@RequestBody Product product){
        iProductService.updateProduct(product);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }
    @DeleteMapping("/products/productId/{productId}")
    ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
        iProductService.deleteProduct(productId);
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","delete one product by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> gellAll(){
        List<Product> products = iProductService.gellAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all products");
        headers.add("info","Get all Method called");
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products,headers, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/products/choice/{choice}")
   List<Product>  getByChoice(@PathVariable ("choice") String choice) {
        List<Product> products = iProductService.getByChoice(choice);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by choice"+choice);
        return products;
    }
    @GetMapping("/products/category/{category}")
    ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category){
        List<Product> products = iProductService.getByCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by category");
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products,headers, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/products/price/{price}")
    ResponseEntity<List<Product>> getByLesserPriceThan(@PathVariable ("price") double price){
       List<Product> products= iProductService.getByLesserPriceThan(price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","showing By lesser price"+price);
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products,headers, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/products/brand/{brand}")
    ResponseEntity<List<Product>> getByBrandStartingWith(@PathVariable ("brand") String brand){
        List<Product> products = iProductService.getByBrandStartingWith(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","showing brand start with "+brand);
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products,headers, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/products/productId/{productId}")
    ResponseEntity<Product> getById(@PathVariable("productId") int productId){
        Product product= iProductService.getById(productId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting By Id ");
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers, HttpStatus.OK);
        return responseEntity;
    }
}
