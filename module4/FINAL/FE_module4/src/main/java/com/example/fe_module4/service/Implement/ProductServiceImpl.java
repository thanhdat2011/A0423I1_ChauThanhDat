package com.example.fe_module4.service.Implement;

import com.example.fe_module4.model.Product;
import com.example.fe_module4.repository.IProductRepository;
import com.example.fe_module4.service.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> getProductList(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void removeProductById(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.getReferenceById(id);
    }


    @Override
    public Page<Product> find(Pageable pageable, String keySearch) {
        return iProductRepository.find(pageable, keySearch);
    }
}
