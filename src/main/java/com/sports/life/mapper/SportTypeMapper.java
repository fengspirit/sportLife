package com.sports.life.mapper;

import com.sports.life.entity.SportType;
import com.sports.life.vo.respVO.SportTypePageRespVO;

import java.util.List;

public interface SportTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SportType record);

    int insertSelective(SportType record);

    SportType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SportType record);

    int updateByPrimaryKey(SportType record);

    SportType selectByName(String name);

    List<SportType> selectAllSprots();
}