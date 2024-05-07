package com.demo.portal.test.principle.openclose;

public class HighSchoolStudent extends Student{


    @Override
    public void eat() {
        System.out.println("高中生在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("高中生在睡觉");
    }

    @Override
    public void study() {
        System.out.println("高中生在学习");
    }

    public void doSomething(){
        System.out.println("我是高中生，做高中生做的事");
    }
}
