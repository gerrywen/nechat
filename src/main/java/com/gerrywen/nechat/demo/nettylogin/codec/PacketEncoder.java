package com.gerrywen.nechat.demo.nettylogin.codec;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import com.gerrywen.nechat.demo.nettylogin.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wenguoli
 * @date 2020/1/16 9:59
 */
public class PacketEncoder  extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
