package com.sports.life.service.impl;

import com.sports.life.entity.ActivityImg;
import com.sports.life.mapper.ActivityImgMapper;
import com.sports.life.service.BannerService;
import com.sports.life.vo.respVO.BannerListRespVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    final ActivityImgMapper activityImgMapper;

    /**
     * 小程序首页轮播图
     * @return
     */
    @Override
    public List<BannerListRespVO> allBanner() {
        List<ActivityImg> activityImgs = activityImgMapper.selectAll();
        ArrayList<BannerListRespVO> list = new ArrayList<>();
        for (ActivityImg activityImg :activityImgs){
            BannerListRespVO respVO = new BannerListRespVO();
            respVO.setImage(activityImg.getImgUrl());
            respVO.setTitle(activityImg.getImgDesc());
            list.add(respVO);
        }

        return list;
    }
}
