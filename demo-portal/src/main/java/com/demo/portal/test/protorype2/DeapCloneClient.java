package com.demo.portal.test.protorype2;

import java.io.*;

/**
 * 深克隆
 */
public class DeapCloneClient {
    public static void main(String[] args) {
        RealizeType realizeType = new RealizeType();
        RealizeType realizeType1 = null;
        CloneTest cloneTest = new CloneTest();
        cloneTest.setName("张三");
        realizeType.setCloneTest(cloneTest);
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            //输出流 程序向程序外输入
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/a.txt"));
            objectOutputStream.writeObject(realizeType);
            //输入流 程序外向程序输入
            objectInputStream = new ObjectInputStream(new FileInputStream("d:/a.txt"));
            realizeType1 = (RealizeType) objectInputStream.readObject();
            CloneTest cloneTest1 = realizeType1.getCloneTest();
            cloneTest1.setName("李四");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        realizeType.show();
        realizeType1.show();

    }
}
