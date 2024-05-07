package com.demo.portal.test.factory4;

/**
 * 工厂方法模式
 * 优点：遵循了开闭原则，扩展性极强。比如现在要增加一个型号的BMW，
 *  我们只需要增加一个创建该型号BMW的工厂，这个工厂继承自抽象工厂即可，不需要改变原有代码，可维护性高。
 * 缺点：增加了类的数量，当有成千上万个类型的产品时，就需要有成千上万个工厂类来生产这些产品。
 */
public interface AbstractBMWFactory {

    BMW creatBMW();

}
