package com.sports.life.mapper;

import com.sports.life.entity.WeChatUser;
import org.apache.ibatis.annotations.Param;

public interface WeChatUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WeChatUser record);

    int insertSelective(WeChatUser record);

    WeChatUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WeChatUser record);

    int updateByPrimaryKey(WeChatUser record);

    WeChatUser selectByOpenId( String openId);
}