package com.demo.portal.test.bridge;

public class AVIFile extends VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("AVI文件解析：" + fileName);
    }
}
