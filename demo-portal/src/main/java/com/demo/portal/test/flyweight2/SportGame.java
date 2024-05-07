package com.demo.portal.test.flyweight2;

public class SportGame {

    public static void main(String[] args) {
        Gym soccer = SoccerFactory.getSoccer("上海体育馆");
        soccer.setSport("足球");
        soccer.setPrice(900d);
        Gym soccer1 = SoccerFactory.getSoccer("上海体育馆");
        Gym soccer2 = SoccerFactory.getSoccer("上海体育馆");
        Gym soccer3 = SoccerFactory.getSoccer("北京体育馆");
        soccer2.setSport("篮球");
        soccer2.setPrice(300d);
        soccer.display();
        soccer1.display();
        soccer2.display();
        soccer3.display();
    }
}
