package com.demo.portal.test.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 遥控器
 * 命令模式中的 Invoke(调用者/请求者)
 * 要求命令对象执行请求，通常会持有命令对象，可以持有很多的命令对象。这个是客户端真正触发命令并要求命令执行相应操作的地方，也就是说相当于使用命令对象的入口。
 */
public class RemoteController {

    //开命令集合
    List<Command> onCommands;
    //关命令集合
    List<Command> offCommands;
    //撤销命令
    Command undoCommand;

    //初始化
    public RemoteController(){
        offCommands = new ArrayList<>();
        onCommands = new ArrayList<>();
        // 初始化五组命令，初始化为空命令
        for (int i = 0; i < 5; i++) {
            offCommands.add(i, new NOCommand());
            onCommands.add(i, new NOCommand());
        }
    }

    //设置命令
    public void setCommand(int index, Command noCommand, Command offCommand){
        offCommands.set(index, offCommand);
        onCommands.set(index, noCommand);
    }

    //按下开按钮
    public void onButtonWasPushed(int no){
        //找到命令执行
        onCommands.get(no).execute();
        //确定撤销命令
        undoCommand = onCommands.get(no);
    }

    //按下关按钮
    public void offButtonWasPushed(int no){
        //找到命令执行
        offCommands.get(no).execute();
        //确定撤销命令
        undoCommand = offCommands.get(no);
    }

    public void undoButton(){
        undoCommand.undo();
    }

}
