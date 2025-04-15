package com.sports.life.controller;

import com.sports.life.entity.Test;
import com.sports.life.service.TestService;
import com.sports.life.utils.DataResult;
import com.sports.life.vo.reqVO.TestReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口模块",description = "测试用的")
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    final TestService testService;

    @GetMapping("/index")
    @ApiOperation(value = "swagger2的测试接口")
    public String testResult(){
        return "swagger2测试成功！";
    }

    /**
     * 测试统一返回格式接口
     */
    @GetMapping("/data")
    @ApiOperation(value = "测试封装的统一返回格式接口")
    public DataResult<String> testDataResult(){
        return DataResult.success("统一返回格式接口");
    }

    @PostMapping("/test1")
    @ApiOperation(value = "测试数据库链接是否正常")
    public DataResult<String> test(TestReqVO vo){
        String test = testService.addTest(vo);
        return DataResult.success(test);
    }
}
