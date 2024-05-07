package com.demo.portal.test.adapter;

/**
 * 对象适配器类
 */
public class SDAdapterTF2 implements SDCard {
    // 声明适配者类，实现聚合
    private TFCard tfCard;
    // 有参构造函数
    public SDAdapterTF2(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    public String readSD() {
        System.out.println("adapter read tf card...");
        return tfCard.readTF();
    }

    @Override
    public void writeSd(String msg) {
        System.out.println("adapter write tf card...");
        tfCard.writeTF(msg);
    }

}
