package com.sports.life.service;

import com.sports.life.utils.DataResult;
import com.sports.life.vo.reqVO.ActivityPageVO;
import com.sports.life.vo.reqVO.AddActivityReqVO;
import com.sports.life.vo.respVO.ActivityPageRespVO;
import com.sports.life.vo.respVO.ActivityTypeRespVO;
import com.sports.life.vo.respVO.PageVO;

import java.util.List;

public interface ActivityService {

    //活动新增

    DataResult<String> addActivity(AddActivityReqVO vo);

    //活动分页查询待审核接口
    PageVO<ActivityPageRespVO> selectAllCheckActivity(ActivityPageVO vo);

    //活动审核


    //活动更新

    //活动手动删除

    //活动正常/非正常下架（状态变更）

    //小程序查询接口
   List<ActivityTypeRespVO> selectActivityType(Long acType);
    List<ActivityTypeRespVO> selectAllActivity();
}
