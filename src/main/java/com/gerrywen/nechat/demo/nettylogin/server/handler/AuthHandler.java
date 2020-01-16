package com.gerrywen.nechat.demo.nettylogin.server.handler;

import com.gerrywen.nechat.demo.nettylogin.util.LoginUtil;
import com.gerrywen.nechat.demo.nettylogin.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author wenguoli
 * @date 2020/1/16 15:09
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 判断是否登录，登录过就把授权移除
        if (!SessionUtil.hasLogin(ctx.channel())) {
            ctx.channel().close();
        } else {
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }


//    /**
//     * 移除校验逻辑
//     * @param ctx
//     */
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) {
//        if (LoginUtil.hasLogin(ctx.channel())) {
//            System.out.println("当前连接登录验证完毕，无需再次验证, AuthHandler 被移除");
//        } else {
//            System.out.println("无登录验证，强制关闭连接!");
//        }
//    }
}
