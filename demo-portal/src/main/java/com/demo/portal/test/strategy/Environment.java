package com.demo.portal.test.strategy;

/**
 * 环境角色
 */
public class Environment {

    private Strategy strategy;

    Environment(Strategy strategy){
        this.strategy = strategy;
    }

    public int calculate(int num1, int num2){
        return strategy.calc(num1, num2);
    }
}
