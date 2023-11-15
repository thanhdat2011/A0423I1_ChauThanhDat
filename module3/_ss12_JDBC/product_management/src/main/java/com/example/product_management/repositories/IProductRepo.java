package com.example.product_management.repositories;

import com.example.product_management.models.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();
}
