package com.demo.portal.test.state;

public class NoPass extends FlowState{
    @Override
    void audit() {
        super.context.setState(Context.AUDIT);
        super.context.getState().audit();
    }

    @Override
    void pass() {
        super.context.setState(Context.PASS);
        super.context.getState().pass();
    }

    @Override
    void noPass() {
        System.out.println("不通过...");
    }
}