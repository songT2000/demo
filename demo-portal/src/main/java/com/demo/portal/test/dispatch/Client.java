package com.demo.portal.test.dispatch;

public class Client {
    public static void main(String[] args) {
        Execute execute = new Execute();
        Hero hero = new Hero();
        Hero zed = new Zed();
        Hero fizz = new Fizz();
        System.out.println("-------静态-------");
        execute.execute(hero);
        execute.execute(zed);
        execute.execute(fizz);
        System.out.println("-------动态-------");
        hero.execute();
        zed.execute();
        fizz.execute();
        System.out.println("--------------");
        hero.accept(execute);
        zed.accept(execute);
        fizz.accept(execute);


    }
}
