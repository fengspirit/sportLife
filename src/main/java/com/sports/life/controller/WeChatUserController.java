package com.sports.life.controller;

import com.sports.life.constant.Constant;
import com.sports.life.service.WeChatUserService;
import com.sports.life.utils.DataResult;
import com.sports.life.utils.JwtTokenUtil;
import com.sports.life.vo.reqVO.wechat.LoginReqVO;
import com.sports.life.vo.respVO.WeChatUserRespVO;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class WeChatUserController {

    final WeChatUserService weChatUserService;
    @PostMapping("/public/login")
    @ApiOperation(value = "微信用户登录")
    public DataResult<String> WechatLogin(@RequestBody LoginReqVO vo) throws IOException {
        String token = weChatUserService.userLogin(vo.getCode());
        return DataResult.success(token);
    }

    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取用户信息")
    public DataResult<WeChatUserRespVO> getUserInfo(HttpServletRequest request){
        String userId = JwtTokenUtil.getUserId(request.getHeader("token"));
        WeChatUserRespVO userInfo = weChatUserService.getUserInfo(userId);
        DataResult result = DataResult.success();
        result.setData(userInfo);
        return result;
    }
}
