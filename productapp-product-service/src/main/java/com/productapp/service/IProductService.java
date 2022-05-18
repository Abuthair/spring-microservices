package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> gellAll();
    List<Product> getByChoice(String choice) throws ProductNotFoundException;
    List<Product> getByCategory(String category)throws ProductNotFoundException;
      List<Product> getByLesserPriceThan(double price)throws ProductNotFoundException;
  List<Product> getByBrandStartingWith(String brand)throws ProductNotFoundException;
    Product getById(int productId)throws ProductNotFoundException;
}
