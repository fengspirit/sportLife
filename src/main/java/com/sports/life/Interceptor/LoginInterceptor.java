package com.sports.life.Interceptor;

import com.sports.life.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    // 白名单路径列表（支持 Ant 风格通配符）
    private static final List<String> WHITE_LIST = Arrays.asList(
            "/api/public/**",       // 公开接口
            "/error",              // 错误处理
            "/swagger-ui/**",      // Swagger 文档
            "/v3/api-docs/**"      // OpenAPI 文档

    );
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        String requestURI = request.getRequestURI();
        // 白名单直接放行
        if (isWhiteList(requestURI)) {
            return true;
        }
        try {
            //首先从redis取出登陆时存入的token，如果不能取出说明token已经失效，不能放行
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

            String redisToken = operations.get(token);
            if (redisToken==null){
                //失效则抛出异常
                throw new RuntimeException();
            }
//            //解析成功，放行
//            Map<String, Object> claims = JwtTokenUtil.getAccessToken()
//            //存入thread中，方便各个接口获取用户信息
//            ThreadLocalUtil.set(claims);
            return  true;
        } catch (Exception e) {
            //解析失败，不放行，返回401状态
            response.setStatus(401);
            return false;
        }

    }

    /**
     * 请求结束后执行的方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //情况Thread存入的数据，防止内存泄露
       // ThreadLocalUtil.remove();
    }

    //校验白名单
    private  boolean isWhiteList(String uri){
        return WHITE_LIST.stream().anyMatch(pattern -> new AntPathMatcher().match(pattern, uri));
    }
}
