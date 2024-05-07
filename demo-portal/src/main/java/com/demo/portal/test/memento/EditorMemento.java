package com.demo.portal.test.memento;

/**
 * 编辑器备忘录
 * 备忘录模式中的备忘录(Memento)
 * 存储源发器对象的状态。备忘录对象可以包括一个或多个状态属性，源发器可以根据需要保存和恢复状态。
 */
public class EditorMemento {

    //备忘内容
    private String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }



}

