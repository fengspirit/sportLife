package com.sports.life.controller;

import com.sports.life.entity.SportType;
import com.sports.life.service.SportTypeService;
import com.sports.life.utils.DataResult;
import com.sports.life.vo.reqVO.SportPageReqVO;
import com.sports.life.vo.respVO.PageVO;
import com.sports.life.vo.respVO.SportTypePageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运动类型
 */
@RestController
@Slf4j
@RequestMapping("/api")
@AllArgsConstructor
@Api(tags = "运动类型")
public class SportTypeController {
    final SportTypeService sportTypeService;

    @PostMapping("/add/sport")
    @ApiOperation("添加运动类型")
    public DataResult addSportType(@RequestBody SportType sportType){
         sportTypeService.addSportType(sportType);

         return DataResult.success();
    }

    @PostMapping("/all/sport")
    @ApiOperation(value = "查询所有运动类型")
    public DataResult<PageVO<SportTypePageRespVO>> selectAllSports(@RequestBody SportPageReqVO vo){
        DataResult result = DataResult.success();
        PageVO<SportTypePageRespVO> pageVO = sportTypeService.selectAllSports(vo);
         result.setData(pageVO);
        return result;
    }

}
