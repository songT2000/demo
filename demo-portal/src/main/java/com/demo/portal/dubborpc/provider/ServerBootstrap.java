package com.demo.portal.dubborpc.provider;

import com.demo.portal.dubborpc.netty.NettyServer;

public class ServerBootstrap {

    public static void main(String[] args) {
        // @todo
        NettyServer.startServer("127.0.0.1", 9002);
    }
}
