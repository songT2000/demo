package com.demo.portal.test.command;


/**
 * 命令接口
 * 命令模式中的 Command(抽象命令类)
 * 定义命令的接口，声明执行的方法。
 */
public interface Command {

    //执行命令
    public void execute();
    //撤销命令
    public void undo();
}
