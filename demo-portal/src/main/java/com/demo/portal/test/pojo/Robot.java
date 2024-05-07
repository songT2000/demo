package com.demo.portal.test.pojo;

import com.demo.portal.test.pojo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Robot {

    private String num;

    private Integer age;

    private String address;

    private Boolean isDestroy = false;

    private Status status;

    @Override
    public String toString() {
        return "Robot{" +
                "num='" + num + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", isDestroy=" + isDestroy +
                ", status=" + Status.getName(status.getIndex()) +
                '}';
    }
}
