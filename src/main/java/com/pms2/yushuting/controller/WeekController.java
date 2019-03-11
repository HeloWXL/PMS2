package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Week;
import com.pms2.yushuting.service.WeekService;
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
@Api(tags ="实习周记接口")
@RestController
@RequestMapping("week")
public class WeekController {


    protected Logger logger = LoggerFactory.getLogger(WeekController.class);

    @Resource
    private WeekService weekService;

    @ApiOperation(value="学生添加实习周记")
    @PostMapping("insertWeekSummary")
    public int insertWeekSummary(@RequestBody Week week){
        return weekService.insertWeek(week);
    }
}
