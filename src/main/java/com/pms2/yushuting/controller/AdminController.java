package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Admin;
import com.pms2.yushuting.service.AdminService;
import com.pms2.yushuting.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.pms2.yushuting.utils.Md5Utils.getSaltMD5;

/**
 * @author wangxl
 * @date 2019/3/2
 */
@Api(tags ="管理员接口")
@RestController
@RequestMapping("admin")
public class AdminController {

    protected Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminService adminService;

    @ApiOperation(value="登录检查")
    @PostMapping("checkAdminLogin")
    public Boolean checkLogin(HttpServletRequest request,
                              @RequestParam("username") String username, @RequestParam("password") String password){
        if(Md5Utils.getSaltverifyMD5(password,getSaltMD5(adminService.checkAdmin(username).getAdminPassword()))) {
            Admin admin= adminService.checkAdmin(username);
            //获取学生对象，将其保存在session
            request.getSession().setAttribute("adminsession",admin);
            logger.info(username+"登录成功");
            return true;
        }else{
            logger.info(username+"登录失败");
            return false;
        }
    }

    @ApiOperation(value="获取管理员的session对象")
    @PostMapping("getAdminSession")
    public Admin getAdminSession(HttpServletRequest request,@RequestParam("adminBean") String adminBean){

        Admin admin = (Admin) request.getSession().getAttribute(adminBean);
        if(admin==null){
            return null;
        }else{
            return admin;
        }

    }



}
