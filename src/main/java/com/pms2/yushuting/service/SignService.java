package com.pms2.yushuting.service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pms2.yushuting.mapper.SignMapper;
import com.pms2.yushuting.model.Sign;
import com.pms2.yushuting.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxl
 * @date 2019/3/11
 */
@Service
public class SignService{
    @Resource
    private SignMapper signMapper;

    /**
     * 学生签到
     * @param sign
     * @return
     */
    public int studentSign(Sign sign){
        return signMapper.insert(sign);
    }

    /**
     * 判断学生是否已经进行签到
     * @param sno
     * @return
     */
    public Boolean isSign(String sno){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("student_no",sno);
        entityWrapper.le("sign_date",new Date());
        List<Sign> signList =signMapper.selectList(entityWrapper);
        if(signList.size()>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取签到表信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Map<String,Object> getSignList(Integer pageNo, Integer pageSize){
        EntityWrapper entityWrapper = new EntityWrapper();
        List<Sign> sign = signMapper.selectPage(new Page<Student>(pageNo,pageSize),entityWrapper);
        int count = signMapper.selectCount(entityWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("list",sign);
        map.put("count",count);
        return map;
    }

}
