package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Admin;
import com.pms2.yushuting.model.Teacher;
import com.pms2.yushuting.service.TeacherService;
import com.pms2.yushuting.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import static com.pms2.yushuting.utils.Md5Utils.getSaltMD5;

/**
 * @author wangxl
 * @date 2019/3/2
 */
@Api(tags ="教师接口")
@RestController
@RequestMapping("teacher")
public class TeacherController {
    protected Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Resource
    private TeacherService teacherService;

    @ApiOperation(value="登录检查")
    @PostMapping("checkTeacherLogin")
    public Boolean checkLogin(HttpServletRequest request,
                              @RequestParam("tno") String tno, @RequestParam("password") String password){
        if(Md5Utils.getSaltverifyMD5(password,getSaltMD5(teacherService.checkTeacher(tno).getTeacherPassword()))) {
           Teacher teacher= teacherService.checkTeacher(tno);
            //获取学生对象，将其保存在session
            request.getSession().setAttribute("teachersession",teacher);
            logger.info("教师编号"+tno+"登录成功");
            return true;
        }else{
            logger.info("教师编号"+tno+"登录失败");
            return false;
        }
    }

    @ApiOperation(value="获取教师列表")
    @PostMapping("getTeacherList")
    public Map<String,Object> getStudentList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        if(teacherService.getTeacherList(pageNo,pageSize).size()>0){
            logger.info("获取教师列表成功");
            return teacherService.getTeacherList(pageNo,pageSize);
        }else{
            logger.info("获取教师列表失败");
            return null;
        }
    }


    @ApiOperation(value="获取教师的session对象")
    @PostMapping("getTeacherSession")
    public Teacher getTeacherSession(HttpServletRequest request, @RequestParam("teacherBean") String teacherBean){

        Teacher teacher= (Teacher) request.getSession().getAttribute(teacherBean);
        if(teacher==null){
            return null;
        }else{
            return teacher;
        }

    }
}
