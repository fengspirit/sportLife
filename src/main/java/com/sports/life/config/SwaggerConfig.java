package com.sports.life.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * SwaggerConfig
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    private boolean enable=true;

    @Bean
    public Docket creatRestApi(){

        /**
         * 这是为了我们在用 swagger 测试接口的时候添加头部信息
         */
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder refreshTokenPar = new ParameterBuilder();

        tokenPar.name("authorization").description("swagger测试用(模拟authorization传入)非必填 header")
                .modelRef(new ModelRef("string")).parameterType("header").required(false);

        refreshTokenPar.name("refresh_token").description("swagger测试用(模拟刷新token传入)非必填 header")
                .modelRef(new ModelRef("string")).parameterType("header").required(false);
        /**
         * 多个的时候 就直接添加到 pars 就可以了
         */
        pars.add(tokenPar.build());
        pars.add(refreshTokenPar.build());

        //基础配置
        return  new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sports.life.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .enable(enable);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("运动生活后台管理系统")
                .description("运动生活后台管理系统后端接口文档")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
