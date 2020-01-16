package com.gerrywen.nechat.demo.nettylogin.codec;

import com.gerrywen.nechat.demo.nettylogin.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author wenguoli
 * @date 2020/1/16 9:48
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
