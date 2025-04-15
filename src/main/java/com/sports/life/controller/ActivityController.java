package com.sports.life.controller;

import com.sports.life.service.ActivityService;
import com.sports.life.utils.DataResult;
import com.sports.life.vo.reqVO.ActivityPageVO;
import com.sports.life.vo.reqVO.AddActivityReqVO;
import com.sports.life.vo.respVO.ActivityPageRespVO;
import com.sports.life.vo.respVO.ActivityTypeRespVO;
import com.sports.life.vo.respVO.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "活动模块")
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class ActivityController {

    final ActivityService activityService;

    @PostMapping("/add")
    @ApiOperation(value = "发起活动接口")
    public DataResult<String> addActivity(@RequestBody AddActivityReqVO vo){
        DataResult<String> result = activityService.addActivity(vo);
        return result;
    }

    @PostMapping("/checkAllActivity")
    @ApiOperation(value = "审核接口分页查询")
    public DataResult<PageVO<ActivityPageRespVO>> selectAllCheckActivity(@RequestBody ActivityPageVO vo){
        DataResult result = DataResult.success();
        PageVO<ActivityPageRespVO> list = activityService.selectAllCheckActivity(vo);
        result.setData(list);
        return result;

    }

    /**
     * 根据运动类型查询所有活动数据
     * @param acType
     * @return
     */
    @GetMapping("/public/activity/type/{acType}")
    @ApiOperation(value = "微信小程序查询列表")
    public DataResult<List<ActivityTypeRespVO>> selectSportTypeActivity(@PathVariable(value = "acType" ,required = false) Long acType){
        if(acType==null){
            System.out.println("没传参数");
        }
        List<ActivityTypeRespVO> list = activityService.selectActivityType(acType);
        return DataResult.success(list);
    }

    /**
     * 查询所有活动数据
     *
     * @return
     */
    @GetMapping("/public/activity/type")
    @ApiOperation(value = "微信小程序查询列表")
    public DataResult<List<ActivityTypeRespVO>> selectAllActivity(){
        List<ActivityTypeRespVO> list = activityService.selectAllActivity();
        return DataResult.success(list);
    }
}
