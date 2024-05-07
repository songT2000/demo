package com.demo.portal.test.testlock;


/**
 * DCL单例模式
 */
public class SingletonMgr03 {

    public static SingletonMgr03 INSTANCE = null;

    private SingletonMgr03() {
    }

    public static synchronized SingletonMgr03 getINSTANCE() {//锁粒度粗
        // maybe need do something
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingletonMgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonMgr03 mgr03 = SingletonMgr03.getINSTANCE();
                System.out.println(mgr03.hashCode());
            }).start();
        }
    }
}
