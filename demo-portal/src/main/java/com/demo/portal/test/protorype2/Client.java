package com.demo.portal.test.protorype2;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        RealizeType realizeType = new RealizeType();
        CloneTest cloneTest = new CloneTest();
        cloneTest.setName("张三");
        realizeType.setCloneTest(cloneTest);
        //该克隆属于浅克隆
        RealizeType realizeType1 = realizeType.clone();
        CloneTest cloneTest1 = realizeType1.getCloneTest();
        cloneTest1.setName("李四");
        System.out.println(realizeType);
        System.out.println(realizeType1);
        System.out.println(realizeType1 == realizeType);
        System.out.println(realizeType1.equals(realizeType));
        System.out.println("========================");
        realizeType.show();
        realizeType1.show();
    }
}
