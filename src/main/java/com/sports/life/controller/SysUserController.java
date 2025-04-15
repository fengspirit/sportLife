package com.sports.life.controller;

import com.sports.life.constant.Constant;
import com.sports.life.service.SysUserService;
import com.sports.life.utils.DataResult;
import com.sports.life.utils.JwtTokenUtil;
import com.sports.life.vo.reqVO.LoginReqVO;
import com.sports.life.vo.reqVO.SysUserRegisterReqVO;
import com.sports.life.vo.respVO.LoginRespVO;
import com.sports.life.vo.respVO.UserInfoRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Pattern;

/**
 * 后台系统用户模块
 */
@Api(tags = "后台系统用户模块")
@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class SysUserController {


    final SysUserService sysUserService;

    @PostMapping("/sysuser/register")
   @ApiOperation("用户注册")
    public DataResult<String> register (@RequestBody SysUserRegisterReqVO vo){
        String register = sysUserService.register(vo);
        log.info("注册结果：{}",register);
        return  DataResult.success(register);
    }

    @PostMapping("/sysuser/login")
    @ApiOperation("用户登录")
    public DataResult<LoginRespVO> loginSysUser(@RequestBody SysUserRegisterReqVO vo){
        LoginRespVO respVO = sysUserService.loginSysUser(vo);
        log.info("登录结果：{}",respVO.getUsername());
        return DataResult.success(respVO);
    }

    @GetMapping("/sysuser/userInfo")
    @ApiOperation(value = "登录用户信息")
    public DataResult<UserInfoRespVO> userInfo(HttpServletRequest request){
        //String userName = JwtTokenUtil.getUserName(request.getHeader(Constant.JWT_USER_NAME));
        ;
        String userName = JwtTokenUtil.getUserId(request.getHeader("authorization"));
        UserInfoRespVO userInfo = sysUserService.getUserInfo(userName);
         log.info("用户信息："+userInfo);
        return DataResult.success(userInfo);

    }
}
