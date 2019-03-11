package com.pms2.yushuting.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pms2.yushuting.mapper.DayMapper;
import com.pms2.yushuting.model.Day;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @date 2019/3/5
 */
@Service
public class DayService {

    @Resource
    private DayMapper dayMapper;

    /**
     * 学生添加实习日记
     * @param day
     * @return
     */
    public int insertDay(Day day){
        int i = dayMapper.insert(day);
        return i ;
    }

    /**
     * 学生修改实习日记
     * @param day
     * @param sno
     * @return
     */
    public int updateDay(Day day,String sno){
        int i = dayMapper.update(day,new EntityWrapper<Day>().eq("student_no",sno));
        return i ;
    }

    /**
     * 根据学生的学号查询学生的实习日记
     * @param sno
     * @return
     */
    public Day getDayBySno(String sno){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_no",sno);
        List<Day> list = dayMapper.selectList(entityWrapper);
        return list.get(0);
    }

    /**
     * 根据学生的学号查询实习日记是否存在
     * @param sno
     * @return
     */
    public Boolean isExitDayBySno(String sno){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_no",sno);
        List<Day> list =  dayMapper.selectList(entityWrapper);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 获取实习日记列表--分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getDayList(Integer pageNo, Integer pageSize){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<Day> student = dayMapper.selectPage(new Page<Day>(pageNo,pageSize),entityWrapper);
        int count = dayMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",student);
        map.put("count",count);
        return map;
    }

    /**
     * 根据班级获取实习日记列表--分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getDayListByClass(Integer pageNo, Integer pageSize,String cls){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_class",cls);
        List<Day> student = dayMapper.selectPage(new Page<Day>(pageNo,pageSize),entityWrapper);
        int count = dayMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",student);
        map.put("count",count);
        return map;
    }

}
