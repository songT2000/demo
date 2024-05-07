package com.demo.portal.test.config;


import com.demo.portal.test.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ConfigA {

    @Bean
    public Car Car(){
        return new Car();
    }
}
