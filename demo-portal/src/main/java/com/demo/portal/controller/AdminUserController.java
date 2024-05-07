//package com.demo.web.controller;
//
//
//import com.demo.common.domain.SysUser;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * <p>
// * 系统用户 前端控制器
// * </p>
// *
// * @author song
// * @since 2022-07-26
// */
//@RestController
//@RequestMapping("/sys-user")
//public class SysUserController {
//
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public Object login(HttpServletRequest request) {
//        SysUser sysUser = new SysUser();
//        sysUser.setUsername("zhangsan");
//        sysUser.setUserId(1L);
//        request.getSession().setAttribute("user", sysUser);
//        return "登录成功 login Success";
//    }
//
//    @RequestMapping(value = "/center", method = RequestMethod.GET)
//    public Object center(){
//        return "center";
//    }
//
//    @RequestMapping(value = "logout", method = RequestMethod.GET)
//    public Object logout(HttpServletRequest request){
//        request.getSession().removeAttribute("user");
//        return "logout Success";
//    }
//
//    @RequestMapping(value = "error", method = RequestMethod.GET)
//    public Object error(HttpServletRequest request){
//        return "error";
//    }
//
//
//}
