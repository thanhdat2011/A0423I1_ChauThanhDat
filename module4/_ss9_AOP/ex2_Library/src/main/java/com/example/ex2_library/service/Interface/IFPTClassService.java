package com.example.ex2_library.service.Interface;

import com.example.ex2_library.model.FPTClass;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFPTClassService {
    List<FPTClass> findAll();

    FPTClass findById(Long fptClass);
}
