package com.gerrywen.nechat.demo.nettylogin.codec;

import com.gerrywen.nechat.demo.nettylogin.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author wenguoli
 * @date 2020/1/16 14:31
 */
public class Spliter extends LengthFieldBasedFrameDecoder {

    /**
     * 长度域相对整个数据包的偏移量是多少，这里显然是 4+1+1+1=7
     */
    private static final int LENGTH_FIELD_OFFSET = 7;
    /**
     * 长度域的长度是多少，这里显然是 4。
     */
    private static final int LENGTH_FIELD_LENGTH = 4;

    /**
     * 过滤
     * 判断当前发来的数据包是否是满足我的自定义协议
     */
    public Spliter() {
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        // 判断魔数
        if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
            ctx.channel().close();
            return null;
        }

        return super.decode(ctx, in);
    }
}
