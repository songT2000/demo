package com.demo.common.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ApiModel
public class SysConfigParam {

    @ApiModelProperty(value = "配置组", position = 1)
    @NotNull
    private String group;

    @ApiModelProperty(value = "配置项", position = 2)
    @NotNull
    private String item;
}
