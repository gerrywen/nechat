package com.gerrywen.nechat.demo.nettylogin.client.handler;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.LoginRequestPacket;
import com.gerrywen.nechat.demo.nettylogin.protocol.response.LoginResponsePacket;
import com.gerrywen.nechat.demo.nettylogin.session.Session;
import com.gerrywen.nechat.demo.nettylogin.util.LoginUtil;
import com.gerrywen.nechat.demo.nettylogin.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * @author wenguoli
 * @date 2020/1/16 10:15
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) {
//        // 创建登录对象
//        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
//        loginRequestPacket.setUserId(UUID.randomUUID().toString());
//        loginRequestPacket.setUsername("flash");
//        loginRequestPacket.setPassword("pwd");
//
//        // 写数据
//        ctx.channel().writeAndFlush(loginRequestPacket);
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) {

        // 读取用户信息
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUserName();

        if (loginResponsePacket.isSuccess()) {
            System.out.println("[" + userName + "]登录成功，userId 为: " + loginResponsePacket.getUserId());

            // 绑定用户信息
            SessionUtil.bindSession(new Session(userId, userName), ctx.channel());
        } else {
            System.out.println("[" + userName + "]登录失败，原因：" + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }
}
