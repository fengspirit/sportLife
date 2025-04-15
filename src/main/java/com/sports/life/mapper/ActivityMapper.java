package com.sports.life.mapper;

import com.sports.life.entity.Activity;
import com.sports.life.vo.reqVO.ActivityPageVO;
import com.sports.life.vo.respVO.ActivityPageRespVO;
import com.sports.life.vo.respVO.PageVO;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(String id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<ActivityPageRespVO> checkActivity(ActivityPageVO vo);

    List<Activity> selectBySportType(Long acType);
    List<Activity>  selectAllActivity();
}