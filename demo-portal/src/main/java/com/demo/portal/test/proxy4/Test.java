package com.demo.portal.test.proxy4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        CardBiz cardBiz = (CardBiz) context.getBean("cardBizImpl");
        cardBiz.reCharge();
    }
}
