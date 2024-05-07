package com.demo.common.domain;

import java.math.BigDecimal;
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
 * 前台用户表
 * </p>
 *
 * @author song
 * @since 2023-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PortalUser对象", description="前台用户表")
public class PortalUser extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "登录密码，MD5加密")
    private String loginPwd;

    @ApiModelProperty(value = "资金密码，MD5加密")
    private String fundPwd;

    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "姓名")
    private String withdrawName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "登录权限")
    private Boolean loginEnabled;

    @ApiModelProperty(value = "交易权限")
    private Boolean tradeEnabled;

    @ApiModelProperty(value = "充值权限")
    private Boolean rechargeEnabled;

    @ApiModelProperty(value = "提现权限")
    private Boolean withdrawEnabled;

    @ApiModelProperty(value = "兑换权限")
    private Boolean exchangeEnabled;

    @ApiModelProperty(value = "理财权限")
    private Boolean financialEnabled;

    @ApiModelProperty(value = "佣金权限")
    private Boolean commissionEnabled;

    @ApiModelProperty(value = "用户在用户线中的层级")
    private Integer level;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "真实类型")
    private String realType;

    @ApiModelProperty(value = "是否在线")
    private Boolean isOnline;

    @ApiModelProperty(value = "信用评分")
    private Integer creditScore;

    @ApiModelProperty(value = "谷歌密钥")
    private String googleKey;

    @ApiModelProperty(value = "是否绑定谷歌")
    private Boolean isGoogleBound;

    @ApiModelProperty(value = "TRON充值USDT地址")
    private String tronRechargeAddress;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "上次登录时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "上次登录IP")
    private String lastLoginIp;

    @ApiModelProperty(value = "上次登录地址")
    private String lastLoginArea;

    @ApiModelProperty(value = "注册设备")
    private String registerDevice;

    @ApiModelProperty(value = "注册方式")
    private String registerType;

    @ApiModelProperty(value = "用户极速返点，0.01=1%")
    private BigDecimal pointPercentTiming;

    @ApiModelProperty(value = "用户合约返点，0.01=1%")
    private BigDecimal pointPercentContract;

    @ApiModelProperty(value = "首充时间")
    private LocalDateTime firstRechargeTime;

    @ApiModelProperty(value = "首充金额")
    private BigDecimal firstRechargeAmount;

    @ApiModelProperty(value = "首提时间")
    private LocalDateTime firstWithdrawTime;

    @ApiModelProperty(value = "首提金额")
    private BigDecimal firstWithdrawAmount;

    @ApiModelProperty(value = "订单控盘类型，可空")
    private String orderControlType;

    @ApiModelProperty(value = "现货订单控输赢比例")
    private BigDecimal spotControlPercent;

    @ApiModelProperty(value = "极速交易累计流水usdt")
    private BigDecimal totalTimingAmount;

    @ApiModelProperty(value = "合约交易累计流水usdt")
    private BigDecimal totalContractAmount;

    @ApiModelProperty(value = "总充值金额")
    private BigDecimal totalRechargeAmount;

    @ApiModelProperty(value = "总提现金额")
    private BigDecimal totalWithdrawAmount;

    @ApiModelProperty(value = "所属员工")
    private String employee;

    @ApiModelProperty(value = "邀请码")
    private String inviteCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "机器人权限")
    private Boolean robotEnabled;

    @ApiModelProperty(value = "机器人累计使用量")
    private Integer totalRobotCount;

    @ApiModelProperty(value = "机器人累计收益")
    private BigDecimal totalRobotAmount;

    @ApiModelProperty(value = "机器人ID")
    private Long robotId;


}
