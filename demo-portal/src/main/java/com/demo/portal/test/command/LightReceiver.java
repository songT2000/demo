package com.demo.portal.test.command;

/**
 * 电灯开关执行者
 * 命令模式中的Receiver(实现者/接收者)
 */
public class LightReceiver {

    public void on(){
        System.out.println("打开电灯");
    }

    public void off(){
        System.out.println("关闭电灯");
    }

}
