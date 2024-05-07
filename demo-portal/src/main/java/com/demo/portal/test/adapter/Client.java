package com.demo.portal.test.adapter;

/**
 * 客户
 */
public class Client {

    public static void main(String[] args) {
        // 创建电脑对象
        Computer computer = new Computer();
        // 未定义适配器类，电脑只能读取SD卡中的数据
        String s = computer.readSD(new SDCardImpl());
        System.out.println(s);
        // 定义适配器类，使用该电脑读取TF卡中的数据
        String s1 = computer.readSD(new SDAdapterTF());
        System.out.println(s1);

        // 创建适配器类对象，使用该电脑读取TF卡中的数据
        SDAdapterTF2 sdAdapterTF2 = new SDAdapterTF2(new TFCardImpl());
        String s2 = computer.readSD(sdAdapterTF2);
//        String s2 = sdAdapterTF2.readSD();
        System.out.println(s2);
    }
}
