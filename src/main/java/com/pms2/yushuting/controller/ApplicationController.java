package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Application;
import com.pms2.yushuting.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2019/3/11
 */
@Api(tags ="实习申请接口")
@RestController
@RequestMapping("application")
public class ApplicationController {

    protected Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Resource
    private ApplicationService applicationService;


    @ApiOperation(value="添加实习申请")
    @PostMapping("insertApplication")
    public int insertApplication(@RequestBody Application application){
        return applicationService.insertApplication(application);
    }

    @ApiOperation(value="教师批阅实习申请报告-通过")
    @PostMapping("updateApplicationPass")
    public int updateApplicationPass(@RequestParam("sno") String sno){
        return applicationService.updateApplicationPass(sno);
    }

    @ApiOperation(value="教师批阅实习申请报告--不通过")
    @PostMapping("updateApplicationNotPass")
    public int updateApplicationNotPass(@RequestParam("sno") String sno){
        return applicationService.updateApplicationNotPass(sno);
    }

}
