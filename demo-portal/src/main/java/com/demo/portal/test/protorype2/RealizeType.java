package com.demo.portal.test.protorype2;

import java.io.Serializable;

/**
 * 原型模式
 * 抽象原型类
 * 具体原型类
 * 访问类
 * <p>
 * 原型模式的克隆分威浅克隆和深克隆
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址
 * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不在指向原有对象的内存地址
 */
public class RealizeType implements Cloneable, Serializable {

    private CloneTest cloneTest;

    public CloneTest getCloneTest() {
        return cloneTest;
    }

    public void setCloneTest(CloneTest cloneTest) {
        this.cloneTest = cloneTest;
    }

    public RealizeType() {
        System.out.println("具体原型对象创建成功！");
    }

    @Override
    protected RealizeType clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (RealizeType) super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void show(){
        System.out.println(this.getCloneTest().getName());
    }
}
