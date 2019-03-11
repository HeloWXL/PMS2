package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Student;
import com.pms2.yushuting.service.StudentService;
import com.pms2.yushuting.utils.ExcelUtil;
import com.pms2.yushuting.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.pms2.yushuting.utils.Md5Utils.getSaltMD5;
import static com.pms2.yushuting.utils.ObjectUtils.isEmpty;

/**
 * @author wangxl
 * @date 2019/3/2
 */
@Api(tags ="学生接口")
@RestController
@RequestMapping("student")
public class StudentController {

    protected Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentService studentService;

    @ApiOperation(value="登录检查")
    @PostMapping("checkStudentLogin")
    public Boolean checkLogin(HttpServletRequest request,
                                          @RequestParam("sno") String sno, @RequestParam("password") String password){

        if(Md5Utils.getSaltverifyMD5(password,getSaltMD5(studentService.checkStudent(sno).getStudentPassword()))) {
            Student student = studentService.checkStudent(sno);
            //获取学生对象，将其保存在session
            request.getSession().setAttribute("studentsession",student);
            logger.info("学生登录成功");
            return true;
        }else{
            logger.info("学生登录失败");
            return false;
        }
    }

    @ApiOperation(value="获取学生的session对象")
    @PostMapping("getStudentSession")
    public Student getTeacherSession(HttpServletRequest request,@RequestParam("studentBean") String studentBean){
        String key = request.getParameter("studentBean");
        if(("").equals(key)){
            return null;
        }else{
            Student student = (Student) request.getSession().getAttribute(key);
            return student;
        }
    }



    @ApiOperation(value="清除学生的session对象")
    @GetMapping("removeStudentSession")
    public void removeStudentSession(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("studentBean");
        try {
            response.sendRedirect("index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("退出登录,正在前往首页...");
    }


    @ApiOperation(value="删除学生")
    @GetMapping("deletestudent")
    public Boolean deleteStudentById(@RequestParam("id") Integer id) {
        int i = studentService.deleteStudent(id);
        if(i==1){
            logger.info("删除成功");
            return true;
        }else{
            logger.info("删除失败");
          return false;
        }
    }

    @ApiOperation(value="根据学号查询学生信息")
    @GetMapping("getStudentBySno")
    public Student getStudentBySno(@RequestParam("sno") String sno) {
        Student student = studentService.checkStudent(sno);
        logger.info("查询成功");
        return student;

    }

    @ApiOperation(value="学生列表")
    @PostMapping("getStudentList")
    public Map<String,Object> getStudentList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        if(studentService.getStudentList(pageNo,pageSize).size()>0){
            logger.info("获取学生列表成功");
            return studentService.getStudentList(pageNo,pageSize);
        }else{
            logger.info("获取学生列表失败");
            return null;
        }
    }

    @ApiOperation(value="根据班级获取学生列表")
    @GetMapping("getStudentListByClass")
    public Map<String,Object> deleteStudentById(@RequestParam("cls") String cls,
                                                @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        if(studentService.getStudentListByClass(cls,pageNo,pageSize).size()>0){
            logger.info("获取班级学生列表成功");
            return studentService.getStudentListByClass(cls,pageNo,pageSize);
        }else{
            logger.info("获取班级学生列表失败");
            return null;
        }
    }

    @ApiOperation(value="获取所有学生的数量")
    @GetMapping("getStudentCount")
    public int getStudentCount() {
        return studentService.getStudentCount();
    }

    @ApiOperation("管理员导入学生实习名单")  //success
    @PostMapping("importStudent")
    public String importStudent(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String pattern = fileName.substring(fileName.lastIndexOf(".") + 1);
        List<List<String>> listContent = new ArrayList<>();
        String message = "导入成功";
        try {
            if (file != null) {
                //文件类型判断
                if (!ExcelUtil.isEXCEL(file)) {
                    logger.info("文件为空");
                    message="文件为空";
                }
                listContent = ExcelUtil.readExcelContents(file, pattern);
                //文件内容判断
                if (listContent.isEmpty()) {
                    logger.info("表格内容为空");
                    message="表格内容为空";
                }
                studentService.importStudentList(listContent);
            } else {
                logger.info("未选择文件");
                message="未选择文件";
            }
        } catch (Exception e) {
            logger.info("文件上传出现异常", e.getMessage(), e);
        }
        logger.info("导入成功");
        return message;
    }
}
