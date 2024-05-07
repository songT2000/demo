package com.demo.portal.test.builder2;

public class Client {

    public static void main(String[] args) {

        Phone phone = new Phone.Builder()
                .cpu("intel")
                .memory("金士顿")
                .screen("华为")
                .mainboard("华硕")
                .build();
        System.out.println(phone);
    }
}
