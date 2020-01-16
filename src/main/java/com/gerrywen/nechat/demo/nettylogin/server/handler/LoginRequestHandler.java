package com.gerrywen.nechat.demo.nettylogin.server.handler;

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
 * @date 2020/1/16 10:33
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        System.out.println(new Date() + ": 收到客户端登录请求……");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setUserName(loginRequestPacket.getUserName());

        if (valid(loginRequestPacket)) {
            // 登录成功
            loginResponsePacket.setSuccess(true);
            // 生成用户id
            String userId = randomUserId();
            loginResponsePacket.setUserId(userId);
            System.out.println("[" + loginRequestPacket.getUserName() + "]登录成功");
            // 记住登录信息
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUserName()), ctx.channel());
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }


    /**
     * 随机生成用户id
     * @return
     */
    private static String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    /**
     * 退出移除绑定
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
