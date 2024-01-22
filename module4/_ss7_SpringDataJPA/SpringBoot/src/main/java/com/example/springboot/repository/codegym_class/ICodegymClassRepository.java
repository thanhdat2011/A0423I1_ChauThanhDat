package com.example.springboot.repository.codegym_class;

import com.example.springboot.model.CodegymClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodegymClassRepository extends JpaRepository<CodegymClass,Long> {
}
