package com.pms2.yushuting.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pms2.yushuting.model.Application;
import com.pms2.yushuting.model.ApplicationKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ApplicationMapper extends BaseMapper<Application> {

    @Update("update application set is_pass = 1 where student_no=#{sno}")
    public int updateApplicationPass(@Param("sno") String sno);

    @Update("update application set is_pass = 2 where student_no=#{sno}")
    public int updateApplicationNotPass(@Param("sno") String sno);
}