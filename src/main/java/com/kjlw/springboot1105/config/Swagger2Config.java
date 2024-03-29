package com.kjlw.springboot1105.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启在线文档
public class Swagger2Config {
    //声明api 文档的属性 构建器
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("SpringBoot中使用Swagger2构建RestFul风格在线api文档")
                .description("OFFCN UJIUYE")
                .termsOfServiceUrl("http://www.ujiuye.com")
                .contact("0708Java")
                .version("1.0")
                .build();
    }

    //配置核心配置信息
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.kjlw.demo115-1.controller"))
                .paths(PathSelectors.any())
                .build();
    }


}
