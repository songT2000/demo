package com.demo.portal.test.flyweight2;

/**
 * 具体享元类
 */
public class Gym implements Soccer {

    String gymName;
    //非享元角色 一般不会出现在享元工厂
    String sport = "足球";
    //非享元角色
    Double price = 500d;

    public Gym(String gymName) {
        this.gymName = gymName;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println("{In[" + gymName + "],[Project:" + sport + "],[Price:" + price + "][" + this + "]}");
    }
}
