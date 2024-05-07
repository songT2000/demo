package com.demo.portal.test.zerenlian;

public class TopLevelProcessor extends Processor {

    public TopLevelProcessor(String name) {
        super(name + " 顶级处理者");
    }

    @Override
    void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 50000) {
            System.out.println("**This request " + request.getId() + " will be handled by " +
                    this.name + " **");
        } else {
            processor.processRequest(request);
        }
    }
}
