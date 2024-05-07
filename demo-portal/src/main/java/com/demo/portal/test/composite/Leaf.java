package com.demo.portal.test.composite;

/**
 * 树叶构件Leaf角色，是组合中的叶节点对象，他没有子节点，用于实现抽象构件角色中声明的公共接口
 */
public class Leaf implements Component{

    private String name;

    public Leaf(String name){
        this.name = name;
    }

    @Override
    public int add(Component component) {
        return 0;
    }

    @Override
    public int remove(Component component) {
        return 0;
    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶构件：" + this.name);
    }
}
