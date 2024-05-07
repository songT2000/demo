package com.demo.portal.test.memento;

/**
 * 编辑器
 * 备忘录模式中的源发器（Originator）
 * 需要保存和恢复状态的对象。它创建一个备忘录对象，用于存储当前对象的状态，也可以使用备忘录对象恢复自身的状态。
 */
public class Editor {
    //编辑内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // 创建备忘录对象，保存当前状态
    public EditorMemento createMemento(){
        return new EditorMemento(content);
    }

    // 恢复备忘录对象保存的状态
    public void restoreMemento(EditorMemento memento){
        content =  memento.getContent();
    }
}
