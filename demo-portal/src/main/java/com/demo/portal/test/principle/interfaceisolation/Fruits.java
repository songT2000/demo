package com.demo.portal.test.principle.interfaceisolation;

public abstract class Fruits {
    private String name;
    private String taste;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public abstract void taste();
}
