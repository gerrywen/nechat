package com.gerrywen.nechat.demo.nettylogin.client.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import com.gerrywen.nechat.demo.nettylogin.protocol.request.HeartBeatRequestPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * program: nechat->HeartBeatTimerHandler
 * description: 客户端定时发心跳
 * author: gerry
 * created: 2020-01-23 09:32
 **/
@ChannelHandler.Sharable
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {

    public static final HeartBeatTimerHandler INSTANCE = new HeartBeatTimerHandler();

    private HeartBeatTimerHandler() {

    }

    private static final int HEARTBEAT_INTERVAL = 5;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        scheduleSendHeartBeat(ctx);

        super.channelActive(ctx);
    }

    private void scheduleSendHeartBeat(ChannelHandlerContext ctx) {
        ctx.executor().schedule(() -> {
            if (ctx.channel().isActive()) {
                ctx.writeAndFlush(new HeartBeatRequestPacket());
                scheduleSendHeartBeat(ctx);
            }
        }, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);

    }
}
