package com.demo.portal.config;

import com.demo.portal.filter.TestFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {


    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new TestFilter2());
        filterRegistrationBean.addUrlPatterns("/sys/*");
        return filterRegistrationBean;
    }

}
