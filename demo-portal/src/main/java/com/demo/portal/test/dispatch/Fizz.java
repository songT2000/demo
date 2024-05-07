package com.demo.portal.test.dispatch;

public class Fizz extends Hero {

    @Override
    public void execute(){
        System.out.println("fizz");
    }

    @Override
    public void accept(Execute execute){
        execute.execute(this);
    }
}
