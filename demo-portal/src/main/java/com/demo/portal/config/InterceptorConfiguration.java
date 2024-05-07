package com.demo.portal.config;

import com.demo.portal.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    public static String[] addPathPatterns = {"/sys-user/center"};
    public static String[] excludePathPatterns = {"/sys-user/login", "/sys-user/logout", "/sys-user/error"};

//    @Bean
//    public InterceptorRegistration myInterceptorRegistration(){
//        InterceptorRegistration interceptorRegistration = new InterceptorRegistration(new TestInterceptor());
//        interceptorRegistration.addPathPatterns("/sys/**");
//        return interceptorRegistration;
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
