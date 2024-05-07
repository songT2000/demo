package com.demo.portal.test.factory5;

/**
 * 抽象工厂模式 （一般应用于需要创建一个产品族（一个工厂生产多种产品））
 *  比如生产一个类型BWM的组成配件（引擎，空调等）
 * 优点：增加固定类型产品的不同具体工厂比较方便。例如现在工厂要生产一个580的BMW，只需要再创建一个580的工厂继承抽象工厂就可以了。
 * 缺点：类图优点复杂，可读性没有工厂方法模式那么好。
 */
public interface AbstractBMW5Factory {

    Engine createEngine();

    AirConditioner createAirConditioner();
}
