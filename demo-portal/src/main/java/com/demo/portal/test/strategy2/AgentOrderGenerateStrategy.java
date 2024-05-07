package com.demo.portal.test.strategy2;

/**
 * 代理用户订单生成策略
 */
public class AgentOrderGenerateStrategy implements OrderGenerateStrategy {
    
    @Override
    public String orderGenerate() {
        System.out.println("生成代理用户订单");
        return "代理用户订单执行";
    }
}
