package com.demo.portal.test.builder;

/**
 * 建造者模式
 * 优点：1建造者模式的封装性很好，使用建造者模式可以有效的封装变化，
 *  在使用建造者模式的场景中，一版产品类和建造者类是比较稳定的，因此，
 *  将主要的业务逻辑封装在指挥者类中对整体而言可以取得比较好的稳定性
 *  2在建造者模式中，客户端不必知道产品的内部组成席间，将产品本身与产品
 *   的创建过程解耦，使得相同的创建过程可以创建不同的产品对象。
 *  3可以更加精细的控制产品的创建过程。将复杂产品的创建步骤分解在不同的
 *  方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程
 *  4建造者模式很容易进行扩展，如果有新的需求，通过实现一个新的建造者类
 *  就可以完成，基本上不用修改之前已经测试通过的代码，因此也就不会对原有
 *  功能引入风险，符合开闭原则
 * 缺点：建造者模式所创建的产品一版具有较多的共同点，其组成部分像是，如果产品
 *  之间的差异性很大，则不适合使用建造者模式，因此其使用范围收到一定的限制
 */
public class Client {

    public static void main(String[] args) {
        BikeBuilder builder  = new MobileBikeBuilder();
        Director director = new Director(builder);
        Bike bike = director.construct();
        System.out.println(bike);
    }
}
