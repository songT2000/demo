package com.demo.portal.test.adapter2;

/**
 * 适配器使得只能匹配VGA的投影仪能投影USB接口
 */
public class AdapterUSB2VGA extends UsbImpl implements VGA {
    @Override
    public void projection() {
        super.showPPT();
    }
}
