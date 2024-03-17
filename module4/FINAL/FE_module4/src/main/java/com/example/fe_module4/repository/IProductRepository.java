package com.example.fe_module4.repository;

import com.example.fe_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product where p_name like %:keySearch%", nativeQuery = true)
    Page<Product> find(Pageable pageable, String keySearch);
}
