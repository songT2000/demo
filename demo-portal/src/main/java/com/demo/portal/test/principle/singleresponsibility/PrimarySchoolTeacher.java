package com.demo.portal.test.principle.singleresponsibility;

public class PrimarySchoolTeacher implements Teacher, Student, Play{
    @Override
    public void eat() {
        System.out.println("小学老师在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("小学老师在休息");
    }

    @Override
    public void play() {
        System.out.println("小学老师在玩");
    }

    @Override
    public void teacher() {
        System.out.println("小学老师在教书");
    }

    @Override
    public void study() {
        System.out.println("小学老师在学习");
    }
}
