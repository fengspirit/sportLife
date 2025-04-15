package com.sports.life.controller;

import com.sports.life.service.BannerService;
import com.sports.life.utils.DataResult;
import com.sports.life.vo.respVO.BannerListRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "轮播图")
@RequestMapping("/api")
@AllArgsConstructor
public class BannerController {

    final BannerService bannerService;

    @GetMapping("/public/getBanner")
    @ApiModelProperty(value = "获取首页轮播图")
    public DataResult<List<BannerListRespVO>> allBanner(){
       List<BannerListRespVO> list = bannerService.allBanner();

       return DataResult.success(list);
   }
}
