package com.gerrywen.nechat.demo.nettylogin.client.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.response.LoginResponsePacket;
import com.gerrywen.nechat.demo.nettylogin.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * program: nechat->LogoutResponseHandler
 * description: 退出处理
 * author: gerry
 * created: 2020-01-20 09:18
 **/
@ChannelHandler.Sharable
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    public static final LogoutResponseHandler INSTANCE = new LogoutResponseHandler();

    private LogoutResponseHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
