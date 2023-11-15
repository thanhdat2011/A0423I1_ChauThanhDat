package com.example.product_management.repositories;

import com.example.product_management.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo{
    private final static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "bread", "honda", 5000, 10));
        products.add(new Product(2, "candy", "honda", 8000, 1));
        products.add(new Product(3, "Coca", "honda", 15000, 5));
        products.add(new Product(4, "Huda", "honda", 10000, 6));
        products.add(new Product(5, "chocolate", "honda", 7000, 4));
    }

    public ProductRepo() {
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
