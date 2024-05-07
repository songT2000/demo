package com.demo.portal.test.command;


/**
 * 电灯打开命令
 * 命令模式中的 Concrete Command(具体命令)
 * 具体的命令，实现命令接口；通常会持有接收者，并调用接收者的功能来完成命令要执行的操作。
 */
public class LightOnCommand implements Command {

    public LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.on();
    }

    @Override
    public void undo() {
        lightReceiver.off();
    }
}
