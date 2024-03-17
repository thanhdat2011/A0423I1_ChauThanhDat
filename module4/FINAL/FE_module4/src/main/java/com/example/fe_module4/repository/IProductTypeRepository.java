package com.example.fe_module4.repository;

import com.example.fe_module4.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
}
