package com.gerrywen.nechat.demo.nettylogin.client.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author wenguoli
 * @date 2020/1/16 10:19
 */
@ChannelHandler.Sharable
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {


    public static final MessageResponseHandler INSTANCE = new MessageResponseHandler();

    private MessageResponseHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) {
        // 接受来源用户信息
        String fromUserId = messageResponsePacket.getFromUserId();
        String fromUserName = messageResponsePacket.getFromUserName();
        System.out.println(fromUserId + ":" + fromUserName + " -> " + messageResponsePacket
                .getMessage());
    }
}
