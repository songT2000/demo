package com.demo.portal.test.zerenlian;

public class PurchaseRequest {

    private int id;
    private int number;
    private float price;
    private int type;

    public PurchaseRequest(int Type, int Number, float Price) {
        this.type = Type;
        this.number = Number;
        this.price = Price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
