package com.demo.portal.test.zerenlian;

/**
 * 高级处理者
 */
public class AdvancedLevelProcessor extends Processor {

    public AdvancedLevelProcessor(String name) {
        super(name + " 高级处理者");
    }

    @Override
    void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 30000 && request.getPrice() <= 50000) {
            System.out.println("**This request " + request.getId() + " will be handled by " +
                    this.name + " **");
        } else {
            processor.processRequest(request);
        }
    }
}
