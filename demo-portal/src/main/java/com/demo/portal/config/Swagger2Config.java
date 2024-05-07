package com.demo.portal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                //页面标题，导入postman时必须有该项配置
                .title("企业管理系统")
                //版本号，导入postman时必须有该项配置
                .version("1.0")
                .description("企业管理平台业务数据构造")
                //创建人
                .contact(new Contact("song","http://localhost:9001/swagger-ui.html","tg0030542@gmail.com"))
                .build();
    }
}


