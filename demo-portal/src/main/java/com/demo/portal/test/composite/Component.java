package com.demo.portal.test.composite;


/**
 * 抽象构件 组合模式
 *  它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。
 *  在透明式的组合模式中抽象构件还声明访问和管理子类的接口。
 *  在安全式的组合模式中不声明访问和管理子类的就，管理工作由树枝构件完成。
 */
public interface Component {

    int add(Component component);

    int remove(Component component);

    Component getChild(int i);

    void operation();
}
