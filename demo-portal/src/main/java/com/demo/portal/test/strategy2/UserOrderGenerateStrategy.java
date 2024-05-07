package com.demo.portal.test.strategy2;

/**
 * 普通用户订单生成策略
 */
public class UserOrderGenerateStrategy implements OrderGenerateStrategy {

    @Override
    public String orderGenerate() {
        System.out.println("生成普通用户订单");
        return "普通用户订单执行";
    }
}
