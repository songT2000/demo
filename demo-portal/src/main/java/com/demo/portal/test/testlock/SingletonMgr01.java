package com.demo.portal.test.testlock;

/**
 * 单例模式
 */
public class SingletonMgr01 {

    public static SingletonMgr01 INSTANCE = new SingletonMgr01();

    private SingletonMgr01(){}

    public static SingletonMgr01 getINSTANCE(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        SingletonMgr01 mgr01 = SingletonMgr01.getINSTANCE();
        SingletonMgr01 mgr02 = SingletonMgr01.getINSTANCE();
        System.out.println(mgr01 == mgr02);
    }
}
