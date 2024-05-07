package com.demo.common.domain;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有的状态码在这里定义
 * message接收如下几种格式
 * <p>
 * CommonConstant.NEED_I18N_SUFFIX：RestResponse会把message自动变成RSP_MSG.code()#I18N
 * XXX.XXX#I18N：不会变更字符，会前往i18n_translate表找相应翻译
 * 其它任意字符不以#I18N结尾：不会变更字符，直接输出
 * <p>
 *
 * @author Barry
 * @date 2018-05-12
 */
public enum ResponseCode {
    /**
     * 请求成功
     **/
    OK("OK"),
    ERROR("ERROR"),
    SYS_DATA_STATUS_ERROR("SYS_DATA_STATUS_ERROR"),
    SYS_REQUEST_PARAM_ILLEGAL("SYS_REQUEST_PARAM_ILLEGAL"),
    ;

    /***************************系统类***************************/

    private String message;

    static Map<String, ResponseCode> enumMap = new HashMap<>();

    static {
        for (ResponseCode rsp : ResponseCode.values()) {
            enumMap.put(rsp.name(), rsp);
        }
    }

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static ResponseCode getEnum(String code) {
        return enumMap.get(code);
    }

    /**
     * 是否是正确返回编码
     *
     * @param rsp 编码
     * @return boolean
     */
    @JSONField(serialize = false)
    public static boolean isOkRsp(ResponseCode rsp) {
        return rsp != null && rsp == OK;
    }

    /**
     * 是否是正确返回编码
     *
     * @param code 编码
     * @return boolean
     */
    @JSONField(serialize = false)
    public static boolean isOkRsp(String code) {
        if (StrUtil.isBlank(code)) {
            return false;
        }
        ResponseCode rsp = getEnum(code);
        return isOkRsp(rsp);
    }

    @Override
    public String toString() {
        return this.name();
    }
}
