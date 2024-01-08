package com.example.ex_product_management.repository;

import com.example.ex_product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findProductById(String id);


    void removeProduct(Product product);

    List<Product> findProductByName(String productName);
}
