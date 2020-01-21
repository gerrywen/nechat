package com.gerrywen.nechat.demo.nettylogin.codec;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import com.gerrywen.nechat.demo.nettylogin.protocol.PacketCodeC;

import java.util.List;

/**
 * program: nechat->PacketCodecHandler
 * description:
 * author: gerry
 * created: 2020-01-21 21:36
 **/
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {

    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    private PacketCodecHandler() {

    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, List<Object> out) {
        ByteBuf byteBuf = ctx.channel().alloc().ioBuffer();
        PacketCodeC.INSTANCE.encode(byteBuf, packet);
        out.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) {
        out.add(PacketCodeC.INSTANCE.decode(byteBuf));
    }
}
