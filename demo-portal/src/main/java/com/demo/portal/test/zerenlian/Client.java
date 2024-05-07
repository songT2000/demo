package com.demo.portal.test.zerenlian;

public class Client {

    public Client(){

    }

    public PurchaseRequest sendPurchaseRequest(int type, int number, float price){

        return new PurchaseRequest(type, number, price);
    }

}
