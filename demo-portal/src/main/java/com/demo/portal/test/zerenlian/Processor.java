package com.demo.portal.test.zerenlian;

/**
 * 抽象处理者
 */
public abstract class Processor {

    public String name;

    Processor processor;

    public Processor(String name){
        this.name = name;
    }

    //处理请求
    abstract void processRequest(PurchaseRequest request);

    //设置后续处理者
    protected void setSuccessor(Processor processor) {
        this.processor = processor;
    }

}
