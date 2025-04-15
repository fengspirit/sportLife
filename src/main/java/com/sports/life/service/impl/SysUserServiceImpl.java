package com.sports.life.service.impl;

import com.sports.life.constant.Constant;
import com.sports.life.entity.SysUser;
import com.sports.life.exception.BusinessException;
import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.mapper.SysUserMapper;
import com.sports.life.service.RedisService;
import com.sports.life.service.SysUserService;
import com.sports.life.utils.DataResult;
import com.sports.life.utils.JwtTokenUtil;
import com.sports.life.vo.reqVO.LoginReqVO;
import com.sports.life.vo.reqVO.SysUserRegisterReqVO;
import com.sports.life.vo.respVO.LoginRespVO;
import com.sports.life.vo.respVO.UserInfoRespVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {
    final SysUserMapper sysUserMapper;
    final RedisService redisService;
    @Override
    public String register(SysUserRegisterReqVO vo) {
        //校验
        SysUser sysUser = sysUserMapper.selectByName(vo.getUsername());
        if(sysUser!=null){
           new BusinessException(BaseResponseCode.REGISTER_ADD_ERR);
           return "注册失败";
        }
        SysUser user = new SysUser();
        user.setId(UUID.randomUUID().toString());
        user.setStatus(0);
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());
        user.setNickname(vo.getNickname());
        user.setCreateTime(new Date());
        int i = sysUserMapper.insertSelective(user);
        if(i!=1){
            new BusinessException(BaseResponseCode.REGISTER_INSERT_ERR);
        }
        return "注册成功！";
    }

    @Override
    public LoginRespVO loginSysUser(SysUserRegisterReqVO vo) {

        SysUser sysUser = sysUserMapper.selectByName(vo.getUsername());
        if(sysUser==null){
            new BusinessException(BaseResponseCode.SYSUSER_LOGIN_ERR);
        }
        LoginRespVO respVO = new LoginRespVO();
        //jwt
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(Constant.JWT_USER_NAME,sysUser.getUsername());
        //生成token
        String accessToken = JwtTokenUtil.getAccessToken(sysUser.getId(), claims);
        //封装响应数据
        respVO.setUserId(sysUser.getId());
        respVO.setUsername(sysUser.getUsername());
        respVO.setNickname(sysUser.getNickname());
        respVO.setAccessToken(accessToken);
        //respVO.setRefreshToken();
        redisService.set(accessToken,accessToken,30, TimeUnit.MINUTES);
        return respVO;
    }

    @Override
    public UserInfoRespVO getUserInfo(String username) {
        //SysUser sysUser = sysUserMapper.selectByName(username);

        SysUser sysUser = sysUserMapper.selectByPrimaryKey(username);

        UserInfoRespVO respVO = new UserInfoRespVO();
        respVO.setUsername(sysUser.getUsername());
        respVO.setNickName(sysUser.getNickname());
       // respVO.setUserPic(sysUser.getUserPic());
        respVO.setId(sysUser.getId());
        return respVO;
    }
}
