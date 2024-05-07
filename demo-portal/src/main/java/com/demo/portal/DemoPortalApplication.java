package com.demo.portal;


import com.demo.portal.filter.TestTypeExcludeFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


@MapperScan("com.demo.common.mapper")
@ComponentScan(basePackages = {"com.demo"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = TestTypeExcludeFilter.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class)})
//@SpringBootApplication(exclude={com.demo.web.domain.vo.UserVo.class})
//@ComponentScan(basePackages = {"com.demo"})
@SpringBootApplication
//@ServletComponentScan(basePackages = "com.demo.web.filter")
public class DemoPortalApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoPortalApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
//        ConfigA configA = context.getBean(ConfigA.class);
//        Car car = context.getBean(Car.class);
////        Car car = context.getBean("zhangsan", Car.class);
//
//        System.out.println(configA);
//        System.out.println(car);


    }
}
