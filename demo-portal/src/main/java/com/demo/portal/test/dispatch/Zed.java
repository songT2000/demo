package com.demo.portal.test.dispatch;

public class Zed extends Hero {

    @Override
    public void execute() {
        System.out.println("zed");
    }

    @Override
    public void accept(Execute execute){
        execute.execute(this);
    }
}
