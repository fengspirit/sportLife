package com.sports.life.service;

import com.sports.life.entity.SportType;
import com.sports.life.vo.reqVO.SportPageReqVO;
import com.sports.life.vo.respVO.PageVO;
import com.sports.life.vo.respVO.SportTypePageRespVO;

import java.util.List;

public interface SportTypeService {

    //运动类型新增接口
    void addSportType(SportType sportType);

    //查询接口
    PageVO<SportTypePageRespVO> selectAllSports(SportPageReqVO vo);
}
