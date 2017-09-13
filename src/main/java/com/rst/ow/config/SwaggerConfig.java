package com.rst.ow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** 
 * Created by jiaoweiwei on 2017/03/02. 
 */  
@Configuration
@EnableSwagger2  
public class SwaggerConfig {  
    /** 
     * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了） 
     * 
     */  
    @Bean
    public Docket testApi() {  
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.rst.ow.controller"))
                .paths(PathSelectors.any()).build();  
    }  
  
    private ApiInfo apiInfo() {  
        return new ApiInfoBuilder()  
                .title("官网后台-APIs")
                .description("官网后台注册、体验、邮件配置等接口")
                .termsOfServiceUrl("") 
                .version("1.0")  
                .build();  
    }  
}  