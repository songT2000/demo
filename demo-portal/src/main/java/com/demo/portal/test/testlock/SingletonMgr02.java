package com.demo.portal.test.testlock;


/**
 * 单例模式
 */
public class SingletonMgr02 {

    public static SingletonMgr02 INSTANCE = null;

    private SingletonMgr02() {
    }

    public static SingletonMgr02 getINSTANCE() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingletonMgr02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                SingletonMgr02 mgr02 = SingletonMgr02.getINSTANCE();
                System.out.println(mgr02.hashCode());
            }).start();
        }
    }
}
