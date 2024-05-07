package com.demo.portal.test.state;

/**
 * 具体状态类）实现抽象状态定义的接口
 * 状态 审核
 */
public class Audit extends FlowState{
    @Override
    void audit() {
        System.out.println("审核中...");
    }

    @Override
    void pass() {
        super.context.setState(Context.PASS);
        super.context.getState().pass();
    }

    @Override
    void noPass() {
        super.context.setState(Context.NO_PASS);
        super.context.getState().noPass();
    }
}


