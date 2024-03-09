package com.example.ex2_library.service.Implement;

import com.example.ex2_library.model.FPTClass;
import com.example.ex2_library.repository.IFPTClassRepository;
import com.example.ex2_library.service.Interface.IFPTClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FPTClassServiceImpl implements IFPTClassService {
    @Autowired
    private IFPTClassRepository ifptClassRepository;
    @Override
    public List<FPTClass> findAll() {
        return ifptClassRepository.findAll();
    }

    @Override
    public FPTClass findById(Long fptClass) {
        return ifptClassRepository.getReferenceById(fptClass);
    }
}
