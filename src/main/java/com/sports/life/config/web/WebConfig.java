package com.sports.life.config.web;

import com.sports.life.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将注册和登录接口放行
        registry.addInterceptor(loginInterceptor).excludePathPatterns(
                "/swagger/**",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v3/api-docs",
                "/api/sysuser/login",
                "/sysuser/register",
                "/api/upload/**",
                "/uploads/**",
                "/upload/**",
                "/wx/**",
                "/api/**",
                "/question/**");
    }

    /**
     * bug解决【图片上传后不能回显，因为浏览器阻止直接访问本地资源，所以配置映射路径】
     * 并在上面添加白名单
     * addResourceHandler:访问资源映射路径
     * addResourceLocations：资源本地路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:F:/uploads/");
    }

        @Override
    public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
        }

    }
