package com.demo.portal.test.testlock;


/**
 * DCL单例模式
 */
public class SingletonMgr05 {

    public static SingletonMgr05 INSTANCE = null;

    private SingletonMgr05() {
    }

    public static SingletonMgr05 getINSTANCE() {//锁粒度粗
        // maybe need do something
        if (INSTANCE == null) {
            synchronized (SingletonMgr05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new SingletonMgr05();
            }
        }
        return INSTANCE;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonMgr05 mgr05 = SingletonMgr05.getINSTANCE();
                System.out.println(mgr05.hashCode());
            }).start();
        }
    }
}
