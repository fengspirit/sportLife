package com.sports.life.mapper;

import com.sports.life.entity.Apply;

public interface ApplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}