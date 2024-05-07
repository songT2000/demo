package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.common.domain.SysConfig;
import com.demo.common.mapper.SysConfigMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.service.ISysConfigService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author song
 * @since 2023-10-17
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public List<SysConfig> findByItem(String item) {
        List<SysConfig> sysConfigs = this.baseMapper.selectList(new QueryWrapper<SysConfig>().lambda().eq(StringUtils.isEmpty(item), SysConfig::getItem, item));
        return sysConfigs;
    }

    @Override
    public SysConfig findByGroupAndItem(String group, String item) {
        return this.baseMapper.selectOne(new QueryWrapper<SysConfig>().lambda()
                .eq(StringUtils.isEmpty(item), SysConfig::getItem, item)
                .eq(StringUtils.isEmpty(group), SysConfig::getGroup, group));

    }
}
