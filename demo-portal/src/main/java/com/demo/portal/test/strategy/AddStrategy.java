package com.demo.portal.test.strategy;

/**
 * 具体策略
 */
public class AddStrategy implements Strategy {
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
