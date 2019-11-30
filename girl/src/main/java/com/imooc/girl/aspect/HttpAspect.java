package com.imooc.girl.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author panshao
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void beforeLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info(("url={}"), request.getRequestURL());
        //method
        logger.info(("method={}"), request.getMethod());
        //ip
        logger.info(("ip={}"), request.getRemoteAddr());
        //类方法
        logger.info(("class_method={}"), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info(("args={}"), joinPoint.getArgs());
    }

    @After("log()")
    public void afterLog() {
        logger.info("doAfter");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterRetuningLog(Object object) {
        logger.info(("response={}"), object);
    }
}
