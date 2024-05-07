package com.demo.portal.test.testlock;


/**
 * DCL单例模式
 */
public class SingletonMgr04 {

    public static SingletonMgr04 INSTANCE = null;

    private SingletonMgr04() {
    }

    public static SingletonMgr04 getINSTANCE() {//锁粒度粗
        // maybe need do something
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingletonMgr04.class) {
                INSTANCE = new SingletonMgr04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonMgr04 mgr04 = SingletonMgr04.getINSTANCE();
                System.out.println(mgr04.hashCode());
            }).start();
        }
    }
}
