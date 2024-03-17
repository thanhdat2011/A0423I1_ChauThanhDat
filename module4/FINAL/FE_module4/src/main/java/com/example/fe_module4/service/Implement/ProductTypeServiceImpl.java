package com.example.fe_module4.service.Implement;

import com.example.fe_module4.model.ProductType;
import com.example.fe_module4.repository.IProductTypeRepository;
import com.example.fe_module4.service.Interface.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;
    @Override
    public ProductType findById(Long id) {
        return iProductTypeRepository.getReferenceById(id);
    }

    @Override
    public List<ProductType> findAll() {
        return iProductTypeRepository.findAll();
    }
}
