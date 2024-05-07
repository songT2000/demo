package com.demo.portal.controller;


import com.demo.common.domain.SysConfig;
import com.demo.common.domain.param.SysConfigParam;
import com.demo.common.utils.RedisUtil;
import com.demo.service.ISysConfigService;
import com.demo.portal.config.RequestWebsite;
import com.demo.portal.domain.vo.UserVo;
import com.demo.portal.link.ApiUrl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2022-03-23
 */
@RestController
@RequestMapping(value = ApiUrl.SYS_CONFIG)
public class SysConfigController {

    Logger logger = LoggerFactory.getLogger(SysConfigController.class);

    @Autowired
    private ISysConfigService sysConfigService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserVo userVo;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("获取系统配置")
//    @Cacheable(value = "SYS_CONFIG", key = "#p0")
    public List<SysConfig> sysConfigSimpleList(@RequestBody(required = false) SysConfig sysConfig, @RequestWebsite String requestWebsite) {
        logger.debug("获取系统配置--start");
        List<SysConfig> list = sysConfigService.list();
        System.out.println("------requestWebsite-------" + requestWebsite);
        logger.info("------阿里大聚少离多-------" + userVo);
        logger.debug("------requestWebsite-------" + requestWebsite);
        logger.error("------sysConfig-------" + sysConfig);
        logger.debug("获取系统配置--end");
        return list;
    }

    @RequestMapping(value = ApiUrl.SYS_CONFIG_BY_NAME, method = RequestMethod.POST)
    @ApiOperation("获取指定系统配置")
//    @Cacheable(value = "SYS_CONFIG", key = "#item")
    public SysConfig getByItem(@Valid @RequestBody SysConfigParam sysConfigParam) {
        SysConfig sysConfig = sysConfigService.findByGroupAndItem(sysConfigParam.getGroup(), sysConfigParam.getItem());
        System.out.println(userVo);
//        redisUtil.set(item, sysConfig);
        return sysConfig;
    }

}
