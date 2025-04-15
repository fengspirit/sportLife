package com.sports.life.utils;

import com.sports.life.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 通过redis生存全局唯一主键ID工具类
 */
@AllArgsConstructor
@Component
public class RedisIdWork {
     //开始时间戳
     private static final long BEAIN_TIMESTAMP=1640995200L;
     //序列号位数
     private static final int COUNT_BITS=32;


      final RedisService redisService;


      public long nextId(String keyPrefix){

        //生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timestamp = nowSecond-BEAIN_TIMESTAMP;

        //生成序列号
        //获取当前日期，精确到天
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        System.out.println("date: "+date);
        //自增长
        System.out.println("keyPrefix: "+keyPrefix);
        long count = redisService.incrby1("icr：" + keyPrefix + ":" + date);
        // 3.拼接并返回(因为是数字拼接，所以用位运算；简单相加会是字符串)
        return timestamp << COUNT_BITS | count;

    }
}
