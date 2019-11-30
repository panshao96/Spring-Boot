package com.imooc.girl.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author panshao
 */
@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void beforeLog() {
        System.out.println(11111);
    }

    @After("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void afterLog() {
        System.out.println(22222);
    }
}
