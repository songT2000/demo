package com.demo.portal.test.memento;

public class Client {
    public static void main(String[] args) {

        Editor editor = new Editor();
        History history = new History();
        editor.setContent("张三");
        history.push(editor.createMemento());
        System.out.println(editor.getContent());
        editor.setContent("李四");
        history.push(editor.createMemento());
        System.out.println(editor.getContent());
        editor.setContent("王五");
        editor.restoreMemento(history.pop());
        System.out.println(editor.getContent());
        editor.restoreMemento(history.pop());
        System.out.println(editor.getContent());
    }
}
