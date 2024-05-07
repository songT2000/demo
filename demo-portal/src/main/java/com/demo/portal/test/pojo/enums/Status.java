package com.demo.portal.test.pojo.enums;


import java.util.Arrays;

public enum Status {

    ACTIVATE("已激活", 1),
    NOT_ACTIVATE("未激活", 2),
    WAITING_DESTRUCTION("等待销毁", 3);

    private Integer index;
    private String name;

    Status(String name, int i) {
        this.index = i;
        this.name = name;
    }

    public static String getName(Integer index) {
        return Arrays.stream(Status.values()).filter(s -> s.getIndex() == index).findFirst().map(Status::getName).orElse(null);
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


