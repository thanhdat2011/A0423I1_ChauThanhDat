package com.example.ex_product_management.service;

import com.example.ex_product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findProductById(int id);

    void save(Product product);

    void removeProduct(Product product);

    List<Product> findProductByName(String productName);
}
