package com.demo.portal.test.command;

/**
 * 电灯关闭命令
 */
public class LightOffCommand implements Command {

    public LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.off();
    }

    @Override
    public void undo() {
        lightReceiver.on();
    }
}
