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


//    @Aspect
//    public class LoggingAspect {
//
//        @Before("execution(* com.example.project.service.*.*(..))")
//        public void beforeMethodExecution(JoinPoint joinPoint) {
//            System.out.println("Before executing method: " + joinPoint.getSignature().getName());
//        }
//
//        @AfterReturning(pointcut = "execution(* com.example.project.service.*.*(..))", returning = "result")
//        public void afterMethodExecution(JoinPoint joinPoint, Object result) {
//            System.out.println("After executing method: " + joinPoint.getSignature().getName() + ", returned: " + result);
//        }
//
//        @AfterThrowing(pointcut = "execution(* com.example.project.service.*.*(..))", throwing = "exception")
//        public void afterThrowingException(JoinPoint joinPoint, Exception exception) {
//            System.out.println("Exception thrown by method: " + joinPoint.getSignature().getName() + ", Exception: " + exception.getMessage());
//        }
//    }

}
