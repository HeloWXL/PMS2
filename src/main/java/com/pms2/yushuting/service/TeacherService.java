package com.pms2.yushuting.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pms2.yushuting.mapper.StudentMapper;
import com.pms2.yushuting.mapper.TeacherMapper;
import com.pms2.yushuting.model.Student;
import com.pms2.yushuting.model.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @date 2019/3/2
 */
@Service
public class TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    /**
     * 教师登录
     * @param tno
     * @return
     */
    public Teacher checkTeacher(String tno){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("teacher_no",tno);
        List<Teacher> teacherList = teacherMapper.selectList(entityWrapper);
        if (teacherList.size() > 0) {
            return teacherList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 获取教师列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getTeacherList(Integer pageNo, Integer pageSize){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<Teacher> student = teacherMapper.selectPage(new Page<Student>(pageNo,pageSize),entityWrapper);
        int count = teacherMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",student);
        map.put("count",count);
        return map;
    }

}
