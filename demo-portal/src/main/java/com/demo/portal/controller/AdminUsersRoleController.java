//package com.demo.web.controller;
//
//
//import com.demo.common.domain.SysUser;
//import com.demo.web.domain.vo.UserVo;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <p>
// * 用户角色关联 前端控制器
// * </p>
// *
// * @author song
// * @since 2022-09-29
// */
//@RestController
//@RequestMapping("/sys-users-roles")
//public class SysUsersRolesController {
//
//    static List<UserVo> userVoList = new ArrayList<>();
//
//    static {
//        UserVo userVo1 = new UserVo("zhangsan", 30);
//        UserVo userVo2 = new UserVo("lisi", 23);
//        userVoList.add(userVo1);
//        userVoList.add(userVo2);
//    }
//
//    @GetMapping("user/{id}")
//    public UserVo getUserById(@PathVariable("id") Integer id) {
//        return userVoList.get(id);
//    }
//
//}
