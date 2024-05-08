package com.demo.portal.test.bridge;

/**
 * 展抽象化角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色的业务方法。
 */
public class RMVBFile extends VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("RMVB文件解析：" + fileName);
    }
}
