package com.sports.life.mapper;

import com.sports.life.entity.ActivityImg;

import java.util.List;

public interface ActivityImgMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(ActivityImg record);

    int insertSelective(ActivityImg record);

    ActivityImg selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(ActivityImg record);

    int updateByPrimaryKey(ActivityImg record);

    List<ActivityImg> selectAll();
}