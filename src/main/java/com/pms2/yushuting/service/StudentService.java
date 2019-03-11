package com.pms2.yushuting.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pms2.yushuting.mapper.StudentMapper;
import com.pms2.yushuting.model.Student;
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
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    /**
     * 学生登录
     * @param sno
     * @return
     */
    public Student checkStudent(String sno){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_no",sno);
        List<Student> studentList = studentMapper.selectList(entityWrapper);
        if (studentList.size() > 0) {
            return studentList.get(0);
        } else {
            return null;
        }
    }


    /**
     * 删除学生
     * @param id
     * @return
     */
    public int deleteStudent(Integer id){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_id",id);
        return studentMapper.delete(entityWrapper);
    }


    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public  int updateStudent(Student student){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_id",student.getStudentId());
        return studentMapper.update(student,entityWrapper);
    }

    /**
     * 获取学生的总数量
     * @return
     */
    public Integer getStudentCount(){
        EntityWrapper entityWrapper = new EntityWrapper();
        return studentMapper.selectCount(entityWrapper);
    }

    /**
     * 导入学生名单
     * @param list
     */
    public void importStudentList(List<List<String>> list){
        for ( int i = 0 ; i <list.size();i++){
            Student student = new Student();

            String sno = list.get(i).get(0);
            int snolength = sno.length();

            if(sno.substring(snolength-2,snolength).equals(".0")){
                System.out.println(sno.substring(0,snolength-2));
                student.setStudentNo(sno.substring(0,snolength-2));
            }else{
                student.setStudentNo(sno);
            }
            student.setStudentName(list.get(i).get(1));
//            密码默认为学号
            student.setStudentPassword("123456");
            student.setStudentClass(list.get(i).get(2));
            student.setStudentApartment(list.get(i).get(3));
            student.setSutdnetSex(list.get(i).get(4));
            student.setStudentProfession(list.get(i).get(5));
            String age = list.get(i).get(6);

            int length = age.length();
            if(age.substring(length-2, length).equals(".0")){
                student.setStudentAge(Integer.parseInt(age.substring(0,length-2)));
            }else{
                student.setStudentAge(Integer.parseInt(age));
            }
            studentMapper.insert(student);
        }
    }

    /**
     * 获取学生列表 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getStudentList(Integer pageNo, Integer pageSize){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<Student> student = studentMapper.selectPage(new Page<Student>(pageNo,pageSize),entityWrapper);
        int count = studentMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",student);
        map.put("count",count);
        return map;
    }

    /**
     * 根据班级查询学生
     * @param cls
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getStudentListByClass(String cls,Integer pageNo, Integer pageSize){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<Student> student = studentMapper.selectPage(new Page<Student>(pageNo,pageSize),entityWrapper.eq("student_class",cls));
        int count = studentMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",student);
        map.put("count",count);
        return map;
    }
}
