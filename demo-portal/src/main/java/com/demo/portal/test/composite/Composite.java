package com.demo.portal.test.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝构件Composite角色，式组合中的分节点对象，有子节点。他实现抽象构件角色中声明的接口，
 * 他的主要作用的存储和管理子节点，通常包含add,remove,getChild等方法
 */
public class Composite implements Component{

    private List<Component> children = new ArrayList<>();



    @Override
    public int add(Component component) {
        children.add(component);
        return children.indexOf(component);
    }

    @Override
    public int remove(Component component) {
        int i = children.indexOf(component);
        children.remove(component);
        return i;
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}
