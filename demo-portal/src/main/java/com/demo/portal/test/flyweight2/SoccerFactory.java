package com.demo.portal.test.flyweight2;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂角色
 */
public class SoccerFactory {

    public static Map<String, Gym> gymMap = new HashMap<>();

    public static Gym getSoccer(String gymName){
        Gym gym = gymMap.get(gymName);
        if(gym ==null){
            gym = new Gym(gymName);
            gymMap.put(gymName, gym);
        }
        return gym;
    }



}
