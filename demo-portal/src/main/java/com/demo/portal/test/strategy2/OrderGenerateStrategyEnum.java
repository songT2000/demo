package com.demo.portal.test.strategy2;

import java.util.HashMap;
import java.util.Map;

public enum OrderGenerateStrategyEnum {

    USER_ORDER_GENERATE_STRATEGY("1", "com.demo.portal.test.strategy2.UserOrderGenerateStrategy"),
    AGENT_ORDER_GENERATE_STRATEGY("2", "com.demo.portal.test.strategy2.AgentOrderGenerateStrategy")
    ;

    private String userType;

    private String className;

    OrderGenerateStrategyEnum(String userType, String className){
        this.setUserType(userType);
        this.setClassName(className);
    }

//    public static String getClassNameByUserType(String userType){
//        OrderGenerateStrategyEnum orderGenerateStrategyEnum = OrderGenerateStrategyEnum.valueOf(userType);
//        if(orderGenerateStrategyEnum != null){
//            return orderGenerateStrategyEnum.className;
//        }
//        return null;
//    }

    public static Map<String, String> getAllClazz() {
        Map<String, String> map = new HashMap<>();
        for (OrderGenerateStrategyEnum commandEnum : OrderGenerateStrategyEnum.values()) {
            map.put(commandEnum.getUserType(), commandEnum.getClassName());
        }
        return map;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
