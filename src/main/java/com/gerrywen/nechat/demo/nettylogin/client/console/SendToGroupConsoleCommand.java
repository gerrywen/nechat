package com.gerrywen.nechat.demo.nettylogin.client.console;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.GroupMessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * program: nechat->SendToGroupConsoleCommand
 * description: 发送群消息命令
 * author: gerry
 * created: 2020-01-21 21:00
 **/
public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");

        String toGroupId = scanner.next();
        String message = scanner.next();

        // 发送群消息请求
        channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));
    }
}
