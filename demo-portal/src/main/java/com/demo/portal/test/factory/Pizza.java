package com.demo.portal.test.factory;

public abstract class Pizza {

    private String name;

    public Pizza bake(Pizza pizza) {
        return pizza;
    }

    public Pizza box(Pizza pizza) {
        return pizza;
    }

    public Pizza cut(Pizza pizza) {
        return pizza;
    }

    public Pizza prepare(Pizza pizza) {
        return pizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
