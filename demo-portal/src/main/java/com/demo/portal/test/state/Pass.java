package com.demo.portal.test.state;

public class Pass extends FlowState{

    @Override
    void audit() {
        super.context.setState(Context.AUDIT);
        super.context.getState().audit();
    }

    @Override
    void pass() {
        System.out.println("通过啦...");
    }

    @Override
    void noPass() {
        super.context.setState(Context.NO_PASS);
        super.context.getState().noPass();
    }
}