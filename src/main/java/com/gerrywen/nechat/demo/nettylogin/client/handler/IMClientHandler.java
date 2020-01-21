package com.gerrywen.nechat.demo.nettylogin.client.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.*;

/**
 * program: nechat->IMClientHandler
 * description: 多个指令 handler 压缩为一个 handler
 * author: gerry
 * created: 2020-01-21 21:55
 **/
@ChannelHandler.Sharable
public class IMClientHandler extends SimpleChannelInboundHandler<Packet> {


    /**
     * 单利
     */
    public static final IMClientHandler INSTANCE = new IMClientHandler();

    /**
     * 处理平行 Handler
     */
    private Map<Byte, SimpleChannelInboundHandler<? extends Packet>> handlerMap;

    private IMClientHandler() {
        handlerMap = new HashMap<>();

        handlerMap.put(MESSAGE_RESPONSE, MessageResponseHandler.INSTANCE);
        handlerMap.put(CREATE_GROUP_RESPONSE, CreateGroupResponseHandler.INSTANCE);
        handlerMap.put(JOIN_GROUP_RESPONSE, JoinGroupResponseHandler.INSTANCE);
        handlerMap.put(QUIT_GROUP_RESPONSE, QuitGroupResponseHandler.INSTANCE);
        handlerMap.put(LIST_GROUP_MEMBERS_RESPONSE, ListGroupMembersResponseHandler.INSTANCE);
        handlerMap.put(GROUP_MESSAGE_RESPONSE, GroupMessageResponseHandler.INSTANCE);
        handlerMap.put(LOGOUT_RESPONSE, LogoutResponseHandler.INSTANCE);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        handlerMap.get(packet.getCommand()).channelRead(ctx, packet);
    }
}
