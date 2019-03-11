package com.pms2.yushuting.service;

import com.pms2.yushuting.mapper.WeekMapper;
import com.pms2.yushuting.model.Day;
import com.pms2.yushuting.model.Week;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2019/3/10
 */
@Service
public class WeekService {

    @Resource
    private WeekMapper weekMapper;

    /**
     * 学生添加实习周记
     * @param week
     * @return
     */
    public int insertWeek(Week week){
        int i = weekMapper.insert(week);
        return i ;
    }

}
