package com.demo.portal.test.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 编辑器历史记录
 * 备忘录模式中的管理者（Caretaker）
 * 负责保存备忘录对象，但不能修改备忘录对象的内容。它可以存储多个备忘录对象，并决定何时将备忘录恢复给源发器。
 */
public class History {
    private final List<EditorMemento> editorMementos = new ArrayList<>();

    public void push(EditorMemento memento){
        editorMementos.add(memento);
    }

    public EditorMemento pop(){
        int lastIndex = editorMementos.size() -1;
        EditorMemento editorMemento = editorMementos.get(lastIndex);
        editorMementos.remove(lastIndex);
        return editorMemento;
    }

}
