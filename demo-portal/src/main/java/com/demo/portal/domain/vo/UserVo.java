package com.demo.portal.domain.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "user")
@Component
@Validated
public class UserVo {

    @NotNull
    private String username;

    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private List<String> hobbies;

    private Map<Integer, String> girlFriend;

    public UserVo(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public UserVo() {
    }


//    private Dog dog;

    public Map<Integer, String> getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(Map<Integer, String> girlFriend) {
        this.girlFriend = girlFriend;
    }
}
