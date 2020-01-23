package com.gerrywen.nechat.demo.nettylogin.client.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.response.HeartBeatResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * program: nechat->HeartBeatRequestHandler
 * description: 服务端空闲检测处理
 * author: gerry
 * created: 2020-01-23 09:17
 **/
@ChannelHandler.Sharable
public class HeartBeatResponseHandler extends SimpleChannelInboundHandler<HeartBeatResponsePacket> {
    public static final HeartBeatResponseHandler INSTANCE = new HeartBeatResponseHandler();

    private HeartBeatResponseHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatResponsePacket responsePacket) {
        System.out.println("客户端收到服务端心跳响应：" + responsePacket.getVersion());
    }

}
