package com.gerrywen.nechat.demo.nettylogin.server.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.GroupMessageRequestPacket;
import com.gerrywen.nechat.demo.nettylogin.protocol.response.GroupMessageResponsePacket;
import com.gerrywen.nechat.demo.nettylogin.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * program: nechat->GroupMessageRequestHandler
 * description: 来自客户端群消息
 * author: gerry
 * created: 2020-01-21 21:06
 **/
@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    private GroupMessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket requestPacket) {
        // 1.拿到 groupId 构造群聊消息的响应
        String toGroupId = requestPacket.getToGroupId();
        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();
        responsePacket.setFromGroupId(toGroupId);
        responsePacket.setFromUser(SessionUtil.getSession(ctx.channel()));
        responsePacket.setMessage(requestPacket.getMessage());


        // 2. 拿到群聊对应的 channelGroup，写到每个客户端
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(toGroupId);
        channelGroup.writeAndFlush(responsePacket);
    }
}
