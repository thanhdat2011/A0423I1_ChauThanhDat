package com.example.product_management.services;

import com.example.product_management.models.Product;
import com.example.product_management.repositories.IProductRepo;
import com.example.product_management.repositories.ProductRepo;

import java.util.List;

public class ProductService implements IProductService{
    private final static IProductRepo repo = new ProductRepo();
    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }
}
