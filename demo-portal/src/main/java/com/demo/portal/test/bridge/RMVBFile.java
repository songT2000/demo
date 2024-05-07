package com.demo.portal.test.bridge;

public class RMVBFile extends VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("RMVB文件解析：" + fileName);
    }
}
