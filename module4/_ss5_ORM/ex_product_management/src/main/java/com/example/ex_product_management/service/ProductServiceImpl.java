package com.example.ex_product_management.service;

import com.example.ex_product_management.model.Product;
import com.example.ex_product_management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.removeProduct(product);
    }

    @Override
    public List<Product> findProductByName(String productName) {
        return productRepository.findProductByName(productName);
    }

    public Product findProductById(int id) {
        return productRepository.findProductById(id);
    }
}
