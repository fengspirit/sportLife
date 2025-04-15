package com.sports.life.service;

import com.sports.life.vo.respVO.WeChatUserRespVO;

import java.io.IOException;

public interface WeChatUserService {

    String userLogin(String code) throws IOException;

    WeChatUserRespVO  getUserInfo(String userId);
}
