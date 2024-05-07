package com.demo.portal.controller;

import com.demo.common.domain.RestResponse;
import com.demo.portal.link.ApiUrl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiUrl.PORTAL_USER)
public class PortalUserController {

    @RequestMapping(value = ApiUrl.PORTAL_USER_HOME_INFO)
    @ApiOperation("首页信息")
    public RestResponse<Object> queryHomeInfo(){
        //获取首页banner
        //获取用户信息
        //获取标签信息


        return null;
    }


}
