//package com.demo.web.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.demo.common.domain.SysRole;
//import com.demo.common.vo.SysRoleVo;
//import com.demo.service.ISysRoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * <p>
// * 角色表 前端控制器
// * </p>
// *
// * @author song
// * @since 2022-09-29
// */
//@RestController
//@RequestMapping("/sys-role")
//public class SysRoleController {
//
//    @Autowired
//    private ISysRoleService iSysRoleService;
//
//    @GetMapping("page")
//    public List<SysRoleVo> querySysRolePage() {
//
//        List<SysRoleVo> sysRoleVos = iSysRoleService.listObjs(new QueryWrapper<SysRole>(), e -> new SysRoleVo((SysRole) e));
//        return sysRoleVos;
//    }
//
//
//
//}
