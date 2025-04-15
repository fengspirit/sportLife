package com.sports.life.service;

import com.sports.life.vo.reqVO.addApplyReqVO;

import java.util.List;

public interface ApplyService {

    //新增活动的时候，插入对应的报名信息
    void addApply(List<addApplyReqVO> apply, String activityId);
}
