package com.demo.portal.test.facade;

/**
 * 外观模式
 * 外观角色：为多个子系统对外提供一个共同的接口
 * 子系统角色：实现系统的部分功能，客户可以通过外观角色访问它
 *
 * 案列 智能家电控制
 *
 * 好处：降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类
 *  对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易
 * 缺点：不符合开闭原则，修改很麻烦
 *
 * 使用场景
 *  1对分层结构系统构建时，使用外观模式定义子系统中每层的入口点，可以简化子系统之间的依赖关系。
 *  2当一个复杂系统的子系统很多时，外观模式可以为系统设计一个简单的接口供外界访问
 *  3当客户端与多个子系统之间存在很大的联系时，引入外观模式可将他们分离，从而提高子系统的独立性和可移植性
 */
public class Client {
    public static void main(String[] args) {
        IntelligentHomeAppliance intelligentHomeAppliance = new IntelligentHomeAppliance();
        intelligentHomeAppliance.say("打开家电");
    }

}
