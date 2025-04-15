package com.sports.life.utils;

import org.springframework.stereotype.Component;

/**
 *初始化配置代理类
 * 读取yml文件中配置的jwt属性
 */
@Component
public class InitializerUtil {

    public InitializerUtil(TokenSetting tokenSetting) {
        JwtTokenUtil.setJwtProperties(tokenSetting);
    }
}

