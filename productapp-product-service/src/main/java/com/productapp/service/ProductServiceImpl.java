package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public void addProduct(Product product) {
        // TODO Auto-generated method stub
        iProductRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        // TODO Auto-generated method stub
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        // TODO Auto-generated method stub
        iProductRepository.deleteById(productId);
    }

    @Override
    public List<Product> gellAll() {
        // TODO Auto-generated method stub
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> getByChoice(String choice) throws ProductNotFoundException {
        // TODO Auto-generated method stub
        return iProductRepository.findByChoice(choice);
    }

    @Override
    public List<Product> getByCategory(String category) throws ProductNotFoundException {
        // TODO Auto-generated method stub
        return iProductRepository.findByCategory(category);
    }

    @Override
    public List<Product> getByLesserPriceThan(double price) throws ProductNotFoundException {
        return iProductRepository.readByPriceLessThan(price);
    }

    @Override
    public List<Product> getByBrandStartingWith(String brand) throws ProductNotFoundException {
        return iProductRepository.findByBrandStartingWith(brand);
    }

//	@Override
//	public List<Product> getByLesserprice(double price) throws ProductNotFoundException {
//		// TODO Auto-generated method stub
//		return iProductRepository.fi(price);
//	}
//
//	@Override
//	public List<Product> getByBrandStarting(String brand) throws ProductNotFoundException {
//		// TODO Auto-generated method stub
//		return ;
//	}

    @Override
    public Product getById(int productId) throws ProductNotFoundException {
        // TODO Auto-generated method stub
        return iProductRepository.findById(productId);
    }
}
