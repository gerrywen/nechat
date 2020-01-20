package com.gerrywen.nechat.demo.nettylogin.client.console;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.JoinGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * program: nechat->JoinGroupConsoleCommand
 * description: 加入群命令
 * author: gerry
 * created: 2020-01-20 14:10
 **/
public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.print("输入 groupId，加入群聊：");
        String groupId = scanner.next();

        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
