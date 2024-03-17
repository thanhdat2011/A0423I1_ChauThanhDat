package com.example.fe_module4.service.Interface;

import com.example.fe_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getProductList(Pageable pageable);

    void removeProductById(Long id);

    void save(Product product);

    Product findById(Long id);

    Page<Product> find(Pageable pageable, String keySearch);


}
