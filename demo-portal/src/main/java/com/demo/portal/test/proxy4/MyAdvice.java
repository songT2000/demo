package com.demo.portal.test.proxy4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//切面类：存在多个通知Advice（增强的方法）
@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.demo.portal.test.proxy4.CardBizImpl.reCharge(..))")
    public void pointCut(){}

    @Resource(name="logDaoImpl")
    private LogDaoImpl logDaoImpl;

    @Before("pointCut()")
    public void log(){
        System.out.println("正在记录操作信息...");
        logDaoImpl.addLog("reCharge");
    }
}
