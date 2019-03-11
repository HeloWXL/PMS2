package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Day;
import com.pms2.yushuting.service.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2019/3/10
 */
@Api(tags ="实习日记接口")
@RestController
@RequestMapping("day")
public class DayController {

    protected Logger logger = LoggerFactory.getLogger(DayController.class);

    @Resource
    private DayService dayService;

    @ApiOperation(value="学生添加实习日记")
    @PostMapping("insertDaySummary")
    public int insertDaySummary(@RequestBody Day day){
        return dayService.insertDay(day);
    }
}
