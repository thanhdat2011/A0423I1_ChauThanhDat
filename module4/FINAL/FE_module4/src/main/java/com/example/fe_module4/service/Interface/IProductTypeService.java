package com.example.fe_module4.service.Interface;

import com.example.fe_module4.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    ProductType findById(Long id);

    List<ProductType> findAll();
}
