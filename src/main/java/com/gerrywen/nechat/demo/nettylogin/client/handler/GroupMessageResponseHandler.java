package com.gerrywen.nechat.demo.nettylogin.client.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.response.GroupMessageResponsePacket;
import com.gerrywen.nechat.demo.nettylogin.session.Session;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * program: nechat->GroupMessageResponseHandler
 * description: 发送群消息处理
 * author: gerry
 * created: 2020-01-21 21:03
 **/
@ChannelHandler.Sharable
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {


    public static final GroupMessageResponseHandler INSTANCE = new GroupMessageResponseHandler();

    private GroupMessageResponseHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket responsePacket) {
        String fromGroupId = responsePacket.getFromGroupId();
        Session fromUser = responsePacket.getFromUser();
        // 来自群消息响应
        System.out.println("收到群[" + fromGroupId + "]中[" + fromUser + "]发来的消息：" + responsePacket.getMessage());
    }
}
