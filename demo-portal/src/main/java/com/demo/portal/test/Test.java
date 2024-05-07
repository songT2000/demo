package com.demo.portal.test;

import com.demo.portal.DemoPortalApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoPortalApplication.class);
    }
}
