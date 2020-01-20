package com.gerrywen.nechat.demo.nettylogin.client.console;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * program: nechat->SendToUserConsoleCommand
 * description: 发送消息用户命令
 * author: gerry
 * created: 2020-01-20 09:12
 **/
public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();

        // 发送请求消息
        channel.writeAndFlush(new MessageRequestPacket(toUserId,message));
    }
}
