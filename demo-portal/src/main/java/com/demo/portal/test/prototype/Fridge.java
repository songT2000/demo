package com.demo.portal.test.prototype;

/**
 * 模板模式
 * //冰箱抽象类
 */
public abstract class Fridge {

    protected final void store(){
        openDoor();
        put();
        if(needFreezer()){
            freezer();
        }
        closeDoor();
    }

    //打开冰箱门
    protected final void openDoor(){
        System.out.println("打开冰箱门");
    }
    //关闭冰箱门
    protected final void closeDoor(){
        System.out.println("关上冰箱门");
    }
    //是否冷冻（钩子）
    protected boolean needFreezer(){
        return false;
    }
    protected final void freezer(){
        System.out.println("打开冷冻");
    }
    //放如大象
    abstract void put();


}
