package com.pms2.yushuting.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pms2.yushuting.mapper.SummaryMapper;
import com.pms2.yushuting.model.Summary;
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
public class SummaryService {

    @Resource
    private SummaryMapper summaryMapper;


    /**
     * 学生添加实习总结
     * @param summary
     * @return
     */
    public int insertSummary(Summary summary){
        int i = summaryMapper.insert(summary);
        return i ;
    }

    /**
     * 学生修改实习总结
     * @param summary
     * @param sno
     * @return
     */
    public int updateSummary(Summary summary,String sno){
        int i = summaryMapper.update(summary,new EntityWrapper<Summary>().eq("student_no",sno));
        return i ;
    }


    /**
     * 根据学生的学号查询学生的实习总结
     * @param sno
     * @return
     */
    public Summary getSummaryBySno(String sno){
       EntityWrapper entityWrapper = new EntityWrapper();
       entityWrapper.eq("student_no",sno);
       List<Summary>  list = summaryMapper.selectList(entityWrapper);
        return list.get(0);
    }

    /**
     * 根据学生的学号查询实习总结是否存在
     * @param sno
     * @return
     */
    public Boolean isExitSummaryBySno(String sno){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_no",sno);
        List<Summary> list =  summaryMapper.selectList(entityWrapper);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }

    }


    /**
     * 获取实习总结列表--分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getSummaryList(Integer pageNo, Integer pageSize){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<Summary> student = summaryMapper.selectPage(new Page<Summary>(pageNo,pageSize),entityWrapper);
        int count = summaryMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",student);
        map.put("count",count);
        return map;
    }



    /**
     * 根据班级获取实习总结列表--分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getSummaryListByClass(Integer pageNo, Integer pageSize,String cls){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_class",cls);
        List<Summary> student = summaryMapper.selectPage(new Page<Summary>(pageNo,pageSize),entityWrapper);
        int count = summaryMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",student);
        map.put("count",count);
        return map;
    }

}
