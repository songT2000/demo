package com.demo.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Map;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext context;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        Map<String, HandlerMethodArgumentResolver> beansOfType = context.getBeansOfType(HandlerMethodArgumentResolver.class);
        beansOfType.forEach((name, bean) -> {
            resolvers.add(bean);
        });
    }


}
