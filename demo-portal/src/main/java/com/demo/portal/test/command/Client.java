package com.demo.portal.test.command;

public class Client {

    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();
        TVReceiver tvReceiver = new TVReceiver();
        remoteController.setCommand(0, new TVOnCommand(tvReceiver), new TVOffCommand(tvReceiver) );
        LightReceiver lightReceiver = new LightReceiver();
        remoteController.setCommand(1, new LightOnCommand(lightReceiver), new LightOnCommand(lightReceiver) );
        remoteController.onButtonWasPushed(0);
        remoteController.offButtonWasPushed(0);
    }
}
