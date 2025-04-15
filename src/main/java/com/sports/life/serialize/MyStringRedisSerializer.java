package com.sports.life.serialize;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Redis自定义序列化方式
 */
public class MyStringRedisSerializer implements RedisSerializer {
    private final Charset charset;

    public MyStringRedisSerializer(){
        this(StandardCharsets.UTF_8);
    }
    public MyStringRedisSerializer(Charset charset) {
        Assert.notNull(charset,"charset 不能为空");
        this.charset = charset;
    }
    //序列化方式
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        //如果为空就返回
        if (o==null){
            return new byte[0];
        }
        //
        if (o instanceof String){
            return o.toString().getBytes(charset);
        }else {
            String string = JSON.toJSONString(o);
            return string.getBytes(charset);
        }
    }

    //反系列化方式
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return (bytes==null?null:new String(bytes,charset));
    }
}
