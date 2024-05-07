package com.demo.service.impl;

import com.demo.common.domain.PortalUser;
import com.demo.common.mapper.PortalUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.service.IPortalUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 前台用户表 服务实现类
 * </p>
 *
 * @author song
 * @since 2023-10-17
 */
@Service
public class PortalUserServiceImpl extends ServiceImpl<PortalUserMapper, PortalUser> implements IPortalUserService {

}
