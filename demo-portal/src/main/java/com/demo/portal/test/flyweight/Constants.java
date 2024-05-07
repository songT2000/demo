package com.demo.portal.test.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 */
public class Constants {

    private static Map<String, Integer> attackMap = new HashMap<String, Integer>();
    private static Map<String, Integer> defenseMap = new HashMap<String, Integer>();

    static {
        attackMap.put("dragon", 100);
        attackMap.put("goblin", 50);
        attackMap.put("troll", 80);
        defenseMap.put("dragon", 80);
        defenseMap.put("goblin", 20);
        defenseMap.put("troll", 50);
    }

    public static int getAttack(String type) {
        return attackMap.get(type);
    }

    public static int getDefense(String type) {
        return defenseMap.get(type);
    }

}
