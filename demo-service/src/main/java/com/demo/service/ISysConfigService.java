package com.demo.service;

import com.demo.common.domain.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author song
 * @since 2023-10-17
 */
public interface ISysConfigService extends IService<SysConfig> {

    List<SysConfig> findByItem(String item);

    SysConfig findByGroupAndItem(String group, String item);
}
