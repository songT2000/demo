package com.demo.portal.test.zerenlian;

public class IntermediateLevelProcessor extends Processor {

    public IntermediateLevelProcessor(String name) {
        super(name + " 中级处理者");
    }

    @Override
    void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 10000 && request.getPrice() <= 30000) {
            System.out.println("**This request " + request.getId() + " will be handled by " +
                    this.name + " **");
        } else {
            processor.processRequest(request);
        }
    }
}
