package com.sports.life.service.impl;

import com.alibaba.fastjson.JSON;
import com.sports.life.constant.Constant;
import com.sports.life.entity.WeChatInfo;
import com.sports.life.entity.WeChatUser;
import com.sports.life.exception.BusinessException;
import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.mapper.WeChatUserMapper;
import com.sports.life.service.RedisService;
import com.sports.life.service.WeChatUserService;
import com.sports.life.utils.JwtTokenUtil;
import com.sports.life.utils.RedisIdWork;
import com.sports.life.vo.respVO.WeChatUserRespVO;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
@AllArgsConstructor
public class WeChatUserServiceImpl implements WeChatUserService {
//    @Value("${wx.appid}")
//    private String appid;
//
//    @Value("${wx.secret}")
//    private String secret;

    final WeChatUserMapper weChatUserMapper;
    final RedisIdWork redisIdWork;
    final RedisService redisService;

    @Override
    public String userLogin(String code) throws IOException {
        //构造HTTP请求端
        HttpClient httpClient = HttpClients.createDefault();
        // 1. 调用微信接口
        String url = "https://api.weixin.qq.com/sns/jscode2session" +
//                "?appid=" + appid +
//                "&secret=" + secret +
                "?appid=" + "wx1290745127138ab5" +
                "&secret=" + "b8ede50211e83d618e6a110ff63d9def" +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        HttpGet httpGet = new HttpGet(url);
        String responseResult="";
        //接受返回的参数
        HttpResponse response1 = httpClient.execute(httpGet);
        if(response1.getStatusLine().getStatusCode()==200){
            responseResult  = EntityUtils.toString(response1.getEntity(), "UTF-8");
        }
        //获取返回信息
        WeChatInfo weChatInfo = JSON.parseObject(responseResult, WeChatInfo.class);

        //自定义登录状态
        WeChatUser weChatUser = weChatUserMapper.selectByOpenId(weChatInfo.getOpenid());
        long userId = 0;
        if(weChatUser==null){
            WeChatUser chatUser = new WeChatUser();
            userId = redisIdWork.nextId("微信注册：");
            chatUser.setId(userId);
            chatUser.setOpenId(weChatInfo.getOpenid());
            chatUser.setNickName("默认账号");
            chatUser.setAvatarUrl("/static/sport/defaultAc.jpg");
            chatUser.setGender(0);
            chatUser.setRegisterTime(new Date());
            int insertSelective = weChatUserMapper.insertSelective(chatUser);
            if(insertSelective!=1){
                throw new BusinessException(BaseResponseCode.REGISTER_INSERT_ERR);
            }
        }else {
            Long chatUserId = weChatUser.getId();
            userId = chatUserId;
        }

         //生成token
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(Constant.JWT_WECHAT_USER,userId);

        String s = String.valueOf(userId);
        String token = JwtTokenUtil.getAccessToken(s, claims);
        System.out.println("token:"+token);
        redisService.set(s,token,30, TimeUnit.MINUTES);
        return token;
    }

    @Override
    public WeChatUserRespVO getUserInfo(String userId) {
        long id = Long.parseLong(userId);
        WeChatUser weChatUser = weChatUserMapper.selectByPrimaryKey(id);
        WeChatUserRespVO respVO = new WeChatUserRespVO();
        respVO.setNickName(weChatUser.getNickName());
        respVO.setAvatarUrl(weChatUser.getAvatarUrl());
        return respVO;
    }
}
