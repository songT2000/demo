package com.demo.portal.test.principle.singleresponsibility;

public class HighSchoolStudent implements Student, Play{
    @Override
    public void eat() {
        System.out.println("中学生在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("中学生在休息");
    }

    @Override
    public void study() {
        System.out.println("中学生在学习");
    }

    @Override
    public void play() {
        System.out.println("中学生在玩");
    }
}
