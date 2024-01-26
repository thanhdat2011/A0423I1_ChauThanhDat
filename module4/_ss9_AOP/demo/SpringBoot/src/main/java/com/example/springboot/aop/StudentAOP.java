package com.example.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAOP {

    // quản lý tất cả các method
    // @After(" execution(* com.example.springboot.controller.StudentController.*(..))")

    // quản lý 1 method duy nhất
    @After(" execution(* com.example.springboot.controller.StudentController.showList(..))")
    public void callBeforeShowList(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }
}
