package com.demo.portal.test.adapter2;

/**
 * 投影机只能匹配 VGA
 * 通过适配器匹配 USB
 * @param <T>
 */
public class Projector<T> {

    public void projection(T t) {
        if (t instanceof VGA) {
            System.out.println("开始投影");
            VGA vga = new VgaImpl();
            vga = (VGA) t;
            vga.projection();
        } else {
            System.out.println("接口不匹配，无法投影");
        }
    }
}
