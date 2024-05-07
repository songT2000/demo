package com.demo.portal.test.principle.openclose;

public class Student implements Human{
    @Override
    public void eat() {
        System.out.println("学生再吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("学生再睡觉");
    }

    public void study(){
        System.out.println("学生在学习");
    }
}
