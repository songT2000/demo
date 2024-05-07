package com.demo.common.domain;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.demo.common.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 通用Rest返回数据
 *
 * @author Barry
 * @date 2018-05-12
 */
@Data
@NoArgsConstructor
@ApiModel
public class CommonRestResponse<T> {
    /**
     * 是否成功，仅该值可作为判断成功的依据
     **/
    @JSONField(ordinal = 1, serialzeFeatures = SerializerFeature.WriteMapNullValue)
    @ApiModelProperty(value = "是否成功，仅该值可作为判断请求成功的依据", required = true, position = 1)
    protected Boolean success;

    /**
     * 是否发生异常
     **/
    @JSONField(serialize = false, serialzeFeatures = SerializerFeature.WriteMapNullValue)
    @ApiModelProperty(hidden = true)
    protected Boolean exception;

    /**
     * 是否强制登出
     **/
    @JSONField(ordinal = 2, serialzeFeatures = SerializerFeature.WriteMapNullValue)
    @ApiModelProperty(value = "是否被强制登出，强制登出需要将本地 Authorization 删除，并提示用户具体原因，再将用户导向到登录页面", required = true, position = 2)
    protected Boolean forceLogout;

    /**
     * 返回码，success=false时，报告此码给技术，不作为判断成功的依据
     **/
    @JSONField(ordinal = 3, serialzeFeatures = SerializerFeature.WriteMapNullValue)
    @ApiModelProperty(value = "返回码，success=false时，报告此码给技术，不作为判断成功的依据", required = true, position = 3)
    protected String code;

    /**
     * 返回消息
     **/
    @JSONField(ordinal = 4, serialzeFeatures = SerializerFeature.WriteMapNullValue)
    @ApiModelProperty(value = "返回消息，如果success=false，则此处会有值，直接提示用户该值即可", required = true, position = 4)
    protected String message;

    /**
     * 返回数据
     **/
    @JSONField(ordinal = 5, serialzeFeatures = SerializerFeature.WriteMapNullValue)
    @ApiModelProperty(value = "返回数据，一般success=true才会有值", required = true, position = 5)
    protected T data;

    public CommonRestResponse(boolean success, boolean exception, T data, ResponseCode rspCode, Object... params) {
        this.success = success;
        this.exception = exception;
        this.data = data;
        this.code = rspCode.name();
        // 默认不是强制登出
        this.forceLogout = false;
    }

    public CommonRestResponse(Boolean success, Boolean exception, Boolean forceLogout, String code, String message, T data) {
        this.success = success;
        this.exception = exception;
        this.forceLogout = forceLogout;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    public Map<String, Object> toMap(boolean exception, boolean forceLogout) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("success", isOkRsp());
        if (exception) {
            map.put("exception", isExceptionRsp());
        }
        if (forceLogout) {
            map.put("forceLogout", isForceLogoutRsp());
        }
        map.put("code", this.code);
        map.put("message", this.message);
        map.put("data", this.data);
        return map;
    }

    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    public String toOutStr() {
        return this.code + "," + this.message;
    }

    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    public boolean isOkRsp() {
        return Optional.ofNullable(success).orElse(Boolean.FALSE);
    }

    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    public boolean isExceptionRsp() {
        return Optional.ofNullable(exception).orElse(Boolean.FALSE);
    }

    @JSONField(serialize = false)
    @Transient
    @ApiModelProperty(hidden = true)
    public boolean isForceLogoutRsp() {
        return Optional.ofNullable(forceLogout).orElse(Boolean.FALSE);
    }
}
