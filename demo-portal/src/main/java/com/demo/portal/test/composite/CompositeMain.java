package com.demo.portal.test.composite;

/**
 * 组合模式
 *  透明组合模式：抽象根节点角色中声明了所有用于管理成员对象的方法。比如add,remove，getChile等方法
 *      这样做的好处是确保所有的构件都有相同的接口。
 *      透明组合模式的缺点是不够安全，因为叶子对象和容器对象在本质上是有区别的。叶子对象不可能有下一个层级的对象，
 *          即不可能包含成员对象，因此为其提供add,remode等方法没有意义，这在编译中不会出错，但是在运行阶段如果
 *          调用这些方法可能会出错（需要提供相应的错误处理代码）
 *  安全组合模式：在安全组合模式中，在抽象构件角色中没有声明任何用于管理成员对象的方法，而是在树枝节点类中声明并实现
 *      这些方法。安全组合模式的缺点是不够透明，因为叶子构件和容器构件具有不同的方法，且容器构件中用于管理成员对象的
 *      方法没有在抽象构件中定义，因此客户端不能完全正对抽象编程，必须有区别的对待叶子构建和容器构件。
 */
public class CompositeMain {

    public static void main(String[] args) {

        Component component = new Composite();
        component.add(new Leaf("树叶构件01"));
        component.add(new Leaf("树叶构件02"));
        component.add(new Leaf("树叶构件03"));
        component.add(new Leaf("树叶构件04"));
        component.operation();

    }
}
