package com.demo.portal.test.dispatch;

public class Hero {

    public void execute(){
        System.out.println("hero");
    }

    public void accept(Execute execute){
        execute.execute(this);
    }
}
