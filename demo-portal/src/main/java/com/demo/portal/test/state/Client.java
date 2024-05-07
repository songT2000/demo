package com.demo.portal.test.state;

/**
 * 状态模式描述了对象状态的变化以及对象如何在每一种状态下表现出不同的行为，避免了使用if-else或者switch-case语句，
 * 同时代码结构清晰能够保证扩展性和维护性。但是状态模式违法开闭原则，而且在context类中耦合状态对象，当状态多的情况下，
 * 却会导致代码混乱而且不易维护。
 *
 */
public class Client {
    public static void main(String[] args){
        try {
            //下属申请
            System.out.println("提交申请...");
            Context context  = new Context(new Audit());
            context.audit();
            Thread.sleep(100);
            //模拟上级看到申请后的动作
            context.pass();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
