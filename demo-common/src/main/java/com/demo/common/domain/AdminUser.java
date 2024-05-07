package com.demo.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台管理用户表
 * </p>
 *
 * @author song
 * @since 2023-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AdminUser对象", description="后台管理用户表")
public class AdminUser extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "登录密码，MD5加密")
    private String loginPwd;

    @ApiModelProperty(value = "上次登录时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "上次登录IP")
    private String lastLoginIp;

    @ApiModelProperty(value = "上次登录地址")
    private String lastLoginArea;

    @ApiModelProperty(value = "登录密码输入错误次数，输错谷歌验证码也算密错")
    private Integer pwdErrorTimes;

    @ApiModelProperty(value = "谷歌密钥")
    private String googleKey;

    @ApiModelProperty(value = "是否绑定谷歌")
    private Boolean isGoogleBound;

    @ApiModelProperty(value = "是否启用")
    private Boolean isEnabled;

    @ApiModelProperty(value = "是否在线")
    private Boolean isOnline;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
