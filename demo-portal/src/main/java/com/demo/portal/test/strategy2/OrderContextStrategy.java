package com.demo.portal.test.strategy2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 环境角色(根据环境生成需要的策略)
 */
@Component
public class OrderContextStrategy {

    public static OrderGenerateStrategy getInstance(String userType) {
        Map<String, String> allClazz = OrderGenerateStrategyEnum.getAllClazz();
        String className = allClazz.get(userType);
        if (StringUtils.isNotBlank(className)) {
            try {
                OrderGenerateStrategy orderGenerateStrategy = (OrderGenerateStrategy) Class.forName(className).newInstance();
                return orderGenerateStrategy;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
