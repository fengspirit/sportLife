package com.sports.life.service;

import com.sports.life.entity.ActivityImg;

import java.util.List;

public interface ActivityImgService {

    void addImgs(List<ActivityImg> activityImg,String activityId);

    List<ActivityImg> selectAllImg(String activityId);
}
