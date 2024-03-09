package com.example.ex2_library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class studentAOP {
    @After(" execution(* com.example.ex2_library.controller.StudentController.delete(..))")
    public void callBeforeShowList(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }

}
