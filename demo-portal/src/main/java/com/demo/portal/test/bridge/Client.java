package com.demo.portal.test.bridge;


/**
 * 桥接模式
 * 抽象化角色：定义抽象类，并包含一个对实现化对象的引用
 * 扩展抽象化角色：是抽象化角色的子类，实现弗雷中的业务方法，并通过组合关系调用实现化角色的业务方法。
 * 实现化角色：定义实现化角色的接口或抽象类，供扩展抽象化角色调用
 * 具体实现化角色：鬼畜实现化角色接口的具体实现
 */
public class Client {
    public static void main(String[] args) {
        OperatingSystem operatingSystem = new Mac(new AVIFile());
        operatingSystem.play("战狼3");

    }
}
