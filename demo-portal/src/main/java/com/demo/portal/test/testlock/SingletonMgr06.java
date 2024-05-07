package com.demo.portal.test.testlock;


/**
 * DCL单例模式
 */
public class SingletonMgr06 {

    public static volatile SingletonMgr06 INSTANCE = null;

    private SingletonMgr06() {
    }

    public static SingletonMgr06 getINSTANCE() {//锁粒度粗
        // maybe need do something
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingletonMgr06.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonMgr06();
                }
                return INSTANCE;
            }
        }
        return INSTANCE;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonMgr06 mgr06 = SingletonMgr06.getINSTANCE();
                System.out.println(mgr06.hashCode());
            }).start();
        }
    }
}
