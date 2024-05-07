package com.demo.portal.test.zerenlian;

public class LowLevelProcessor extends Processor {

    public LowLevelProcessor(String name) {
        super(name + " 低级处理者");
    }

    @Override
    void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 0 && request.getPrice() <= 10000) {
            System.out.println("**This request " + request.getId() + " will be handled by " +
                    this.name + " **");
        } else {
            processor.processRequest(request);
        }
    }
}
