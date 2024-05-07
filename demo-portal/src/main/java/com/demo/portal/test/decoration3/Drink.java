package com.demo.portal.test.decoration3;

/**
 * 装饰器模式，模拟业务场景（咖啡店咖啡加糖加奶）
 * 装饰器模式 接口
 * 抽象构建角色
 */
public abstract class Drink {

    public String description = "";
    public float price = 0f;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    abstract float cost();
}
