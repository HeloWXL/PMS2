package com.pms2.yushuting.service;

import com.pms2.yushuting.mapper.ApplicationMapper;
import com.pms2.yushuting.model.Application;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2019/3/11
 */
@Service
public class ApplicationService {

    @Resource
    private ApplicationMapper applicationMapper;

    /**
     * 学生添加实习申请
     * @param application
     * @return
     */
    public int insertApplication(Application application){
        return applicationMapper.insert(application);
    }


    /**
     * 实习申请批阅 通过为1  不通过为2
     * @param sno
     * @return
     */
    public int updateApplicationPass(String sno){
        return applicationMapper.updateApplicationPass(sno);
    }

    public int updateApplicationNotPass(String sno){
        return applicationMapper.updateApplicationNotPass(sno);
    }


}
