package com.demo.service.impl;

import com.demo.common.domain.AdminUser;
import com.demo.common.mapper.AdminUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.service.IAdminUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台管理用户表 服务实现类
 * </p>
 *
 * @author song
 * @since 2023-10-17
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

}
