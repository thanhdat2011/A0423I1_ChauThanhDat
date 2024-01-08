package com.example.ex_product_management.repository;

import com.example.ex_product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    private final static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product("P-001", "Acer Nitro 5", 2000.0,"new model","Acer"));
        productList.add(new Product("P-002", "Del 123", 1500.0,"classical","Del"));
        productList.add(new Product("P-003", "HP vallion", 1700.0,"top sales","HP"));
        productList.add(new Product("P-004", "Macbook 2", 3900.0,"new feature","Macbook"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (!isIdExist(product.getId())) {
            productList.add(product);
        } else {
            productList.set(getIndexOfProductById(product.getId()), product);
        }

    }

    @Override
    public Product findProductById(String id) {
        for (Product product:productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new RuntimeException("Error !!!");
    }

    @Override
    public void removeProduct(Product product) {
        productList.remove(product);
    }

    @Override
    public List<Product> findProductByName(String productName) {
       return productList.stream().filter(e -> e.getName().contains(productName)).collect(Collectors.toList());
    }

    private boolean isIdExist(String id) {
        for (Product product: productList) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private int getIndexOfProductById(String id) {
        for (int i=0; i<productList.size();i++) {
            if (productList.get(i).getId().equals(id)) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
