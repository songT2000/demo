package com.demo.portal.test.state;

/**
 * 抽象状态类
 * (定义一个接口以封装使用上下文环境的的一个特定状态相关的行为。)
 */
public abstract class FlowState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    abstract void audit();

    abstract void pass();

    abstract void noPass();
}
