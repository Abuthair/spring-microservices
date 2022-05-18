package com.productapp.repository;

import com.productapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
   @Query("from Product p where p.brand=?1 or p.category=?1")
    List<Product> findByChoice(String choice);
    List<Product> findByCategory(String category);
    List<Product> readByPriceLessThan(double price);
    List<Product> findByBrandStartingWith(String brand);
    Product findById(int productId);
}
