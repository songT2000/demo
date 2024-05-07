package com.demo.portal.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

//    @Email
    private String name;

    private Integer age;

    private String address;

    private Boolean isDestroy = false;


}
