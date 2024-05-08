package com.demo.portal.test.flyweight;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

public class Client {

    public static void main(String[] args) {
//        Set<String> testSet = new HashSet<>();
//        for (int i = 0; i < 100; i++) {
//            testSet.add("00" + i);
//            if(testSet.size() >=10){
//                System.out.println(testSet.size());
//                testSet.clear();
//                System.out.println(testSet.size());
//            }
//        }

//        // 获取当前的LocalDateTime
//        LocalDateTime now = LocalDateTime.now();
//
//// 获取当前LocalDateTime对应的毫秒数
//        long milli = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
//
//        System.out.println("当前LocalDateTime对应的毫秒数为：" + milli);


        ConcreteMonster monster = (ConcreteMonster) MonsterFactory.getMonster("dragon");
        ConcreteMonster monster2 = (ConcreteMonster) MonsterFactory.getMonster("goblin");
        ConcreteMonster monster3 = (ConcreteMonster) MonsterFactory.getMonster("troll");
        ConcreteMonster monster4 = (ConcreteMonster) MonsterFactory.getMonster("troll");
        ConcreteMonster monster5 = (ConcreteMonster) MonsterFactory.getMonster("dragon");
        ConcreteMonster monster6 = (ConcreteMonster) MonsterFactory.getMonster("test");
        ConcreteMonster monster7 = (ConcreteMonster) MonsterFactory.getMonster("test");

        monster.concreteName("不林肯");
        System.out.println("----------------------");
        monster2.concreteName("拜登");
        System.out.println("----------------------");
        monster3.concreteName("麦卡锡");
        System.out.println("----------------------");
        monster4.concreteName("瞌睡乔");
        System.out.println("----------------------");
        monster5.concreteName("懂王");
        System.out.println("----------------------");
        monster6.concreteName("test");
        System.out.println("----------------------");
        monster7.concreteName("test");
    }

}
