package com.example.springboot.service.codegym_class;

import com.example.springboot.model.CodegymClass;
import com.example.springboot.repository.codegym_class.ICodegymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CodegymClassService implements ICodegymClassService{
    @Autowired
    private ICodegymClassRepository iCodegymClassRepository;
    @Override
    public List<CodegymClass> showList() {
        return iCodegymClassRepository.findAll();
    }
}
