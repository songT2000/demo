package com.demo.portal.test.facade;

public class IntelligentHomeAppliance {

    private Light light;
    private TV tv;
    private AirConditioner airConditioner;

    public IntelligentHomeAppliance() {
        this.light = new Light();
        this.tv = new TV();
        this.airConditioner = new AirConditioner();
    }

    public void say(String message) {
        if ("打开家电".equals(message)) {
            on();
        } else if ("关闭家电".equals(message)) {
            off();
        } else {
            System.out.println("听不懂");
        }
    }

    private void on() {
        this.tv.on();
        this.light.on();
        this.airConditioner.on();
    }

    private void off() {
        this.tv.off();
        this.light.off();
        this.airConditioner.off();
    }
}
