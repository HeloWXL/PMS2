package com.pms2.yushuting.controller;

import com.pms2.yushuting.model.Sign;
import com.pms2.yushuting.service.SignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wangxl
 * @date 2019/3/11
 */
@Api(tags ="签到接口")
@RestController
@RequestMapping("sign")
public class SignController {

    protected Logger logger = LoggerFactory.getLogger(SignController.class);

    @Resource
    private SignService signService;

    @ApiOperation(value="签到接口")
    @PostMapping("studentSign")
    public int studentSign(@RequestBody Sign sign){
        return signService.studentSign(sign);
    }

    @ApiOperation(value="是否签到接口")
    @PostMapping("isSign")
    public Boolean isSign(@RequestParam("sno") String sno){
        return signService.isSign(sno);
    }

    @ApiOperation(value="签到表接口")
    @PostMapping("getSignList")
    public Map<String,Object> getSignList(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        if(signService.getSignList(pageNo,pageSize).size()>0){
            return signService.getSignList(pageNo,pageSize);
        }else{
            return null;
        }
    }

}
