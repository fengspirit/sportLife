package com.sports.life.service.impl;

import com.sports.life.entity.ActivityImg;
import com.sports.life.exception.BusinessException;
import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.mapper.ActivityImgMapper;
import com.sports.life.service.ActivityImgService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 轮播图服务层
 */
@Service
@Slf4j
@AllArgsConstructor
public class ActivityImgServiceImpl implements ActivityImgService {

    final ActivityImgMapper activityImgMapper;

    /**
     * 轮播图新增
     * @param activityImg
     */
    @Override
    public void addImgs(List<ActivityImg> activityImg, String activityId) {

        for (ActivityImg img : activityImg) {
            img.setActivityId(activityId);
            img.setCreateTime(new Date());
            int insertResult = activityImgMapper.insertSelective(img);
            if(insertResult != 1){
                throw new BusinessException(BaseResponseCode.IMGS_INSERT_ERR);
            }
        }

    }

    /**
     * 根据活动查询轮播图
     * @param activityId
     * @return
     */
    @Override
    public List<ActivityImg> selectAllImg(String activityId) {
          return null;
    }


}
