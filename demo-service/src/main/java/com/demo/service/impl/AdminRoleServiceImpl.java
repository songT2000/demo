package com.demo.service.impl;

import com.demo.common.domain.AdminRole;
import com.demo.common.mapper.AdminRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.service.IAdminRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author song
 * @since 2023-10-17
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

}
