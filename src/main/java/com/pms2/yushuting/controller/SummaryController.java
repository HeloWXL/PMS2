package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Summary;
import com.pms2.yushuting.service.SummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wangxl
 * @date 2019/3/2
 */
@Api(tags ="实习总结接口")
@RestController
@RequestMapping("summary")
public class SummaryController {

    protected Logger logger = LoggerFactory.getLogger(SummaryController.class);

    @Resource
    private SummaryService summaryService;

    @ApiOperation(value="根据学生的学号查询学生的实习总结")
    @PostMapping("getSummaryBySno")
    public Summary getSummaryBySno(@RequestParam("sno") String sno){
        if(summaryService.isExitSummaryBySno(sno)){
            return summaryService.getSummaryBySno(sno);
        }else{
            return null;
        }
    }


    @ApiOperation(value="学生修改实习总结")
    @PostMapping("updateSummary")
    public int updateSummaryBySno(@RequestBody Summary summary, @RequestParam("sno") String sno){
        return summaryService.updateSummary(summary,sno) ;
    }


    @ApiOperation(value="学生添加实习总结")
    @PostMapping("insertSummary")
    public int insertSummary(@RequestBody Summary summary){
        return summaryService.insertSummary(summary);
    }


    @ApiOperation(value="获取实习总结列表")
    @PostMapping("getSummaryList")
    public Map<String,Object> getSummaryList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        if(summaryService.getSummaryList(pageNo,pageSize).size()>0){
            logger.info("获取实习总结列表成功");
            return summaryService.getSummaryList(pageNo,pageSize);
        }else{
            logger.info("获取实习总结列表失败");
            return null;
        }
    }

    @ApiOperation(value="根据班级获取实习总结列表")
    @PostMapping("getSummaryListByClass")
    public Map<String,Object> getSummaryListByClass(@RequestParam("cls") String cls,
                                                    @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        if(summaryService.getSummaryListByClass(pageNo,pageSize,cls).size()>0){
            logger.info("根据班级获取实习总结列表成功");
            return summaryService.getSummaryListByClass(pageNo,pageSize,cls);
        }else{
            logger.info("根据班级获取实习总结列表失败");
            return null;
        }
    }

}
