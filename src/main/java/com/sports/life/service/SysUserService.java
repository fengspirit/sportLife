package com.sports.life.service;

import com.sports.life.utils.DataResult;
import com.sports.life.vo.reqVO.LoginReqVO;
import com.sports.life.vo.reqVO.SysUserRegisterReqVO;
import com.sports.life.vo.respVO.LoginRespVO;
import com.sports.life.vo.respVO.UserInfoRespVO;

import javax.validation.constraints.Pattern;

public interface SysUserService {

    //用户注册
    String register (SysUserRegisterReqVO vo);

    LoginRespVO loginSysUser(SysUserRegisterReqVO vo);

    UserInfoRespVO getUserInfo(String username);
}
