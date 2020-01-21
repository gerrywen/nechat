package com.gerrywen.nechat.demo.nettylogin.server.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.QuitGroupRequestPacket;
import com.gerrywen.nechat.demo.nettylogin.protocol.response.QuitGroupResponsePacket;
import com.gerrywen.nechat.demo.nettylogin.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * program: nechat->QuitGroupRequestHandler
 * description: 退出请求处理
 * author: gerry
 * created: 2020-01-20 14:40
 **/
@ChannelHandler.Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {

    public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

    private QuitGroupRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket requestPacket) {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 移除
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(ctx.channel());

        // 2. 构造退群响应发送给客户端
        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
        responsePacket.setGroupId(requestPacket.getGroupId());
        responsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(responsePacket);
    }
}
