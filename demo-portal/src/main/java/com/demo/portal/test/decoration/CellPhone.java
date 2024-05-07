package com.demo.portal.test.decoration;

import java.io.Serializable;

public class CellPhone implements Serializable {

    //序列化之后class字节码文件被修改，例如增删属性，此时在反序列化就会出现异常说
    //序列化版本不一致，加上如下属性就能是序列化和反序列化版本一致从而正常运行
    //其中的数值可以随便写
    static final long serialVersionUID = 42L;

    private String name;
    private Integer price;

    //被transient修饰的标识瞬态，不会被序列化
    private transient String color;

    public CellPhone(String name, Integer price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public CellPhone() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}