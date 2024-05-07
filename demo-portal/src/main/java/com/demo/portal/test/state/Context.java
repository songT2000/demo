package com.demo.portal.test.state;

/**
 * 环境类
 * (它定义了客户程序需要的接口并维护一个具体状态角色的实例，将与状态相关的操作委托给当前的Concrete State对象来处理。)
 */
public class Context {

    protected FlowState state;
    protected static final Audit AUDIT = new Audit();
    protected static final NoPass NO_PASS = new NoPass();
    protected static final Pass PASS = new Pass();

    public Context(FlowState state) {
        setState(state);
    }

    public FlowState getState() {
        return state;
    }

    public void setState(FlowState state) {
        this.state = state;
        this.state.setContext(this);
    }

    void audit(){
        this.getState().audit();
    }

    void pass(){
        this.getState().pass();
    }

    void noPass(){
        this.getState().noPass();
    }
}