package com.demo.portal.link;

import org.springframework.stereotype.Component;

@Component
public class ApiUrl {
    public ApiUrl() {
    }

    /**
     * 系统配置
     **/
    public static final String SYS_CONFIG = "/sys/config";
    public static final String SYS_CONFIG_BY_NAME = "/item";
    public static final String PORTAL_USER = "/portal/uer";

    public static final String PORTAL_USER_HOME_INFO = "/home/info";
    public static final String TEST_REDIS = "/test/redis";

    public static final String TEST_REMOVE_LISTENER = "/test/remove/listener";
    public static final String TEST_ADD_LISTENER = "/test/add/listener";

}
