package com.demo.portal.test.flyweight;

import java.util.HashMap;
import java.util.Map;

public class MonsterFactory {

    public static Map<String, Monster> monsterMap = new HashMap<>();

    public static Monster getMonster(String type){
        Monster monster = monsterMap.get(type);
        if(monster == null){
            monster = new ConcreteMonster(type);
            monsterMap.put(type, monster);
        }
        return monster;
    }

}
