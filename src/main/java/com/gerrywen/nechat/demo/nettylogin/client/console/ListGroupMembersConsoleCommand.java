package com.gerrywen.nechat.demo.nettylogin.client.console;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.ListGroupMembersRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * program: nechat->ListGroupMembersConsoleCommand
 * description: 群列表命令
 * author: gerry
 * created: 2020-01-20 14:15
 **/
public class ListGroupMembersConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();

        System.out.print("输入 groupId，获取群成员列表：");
        String groupId = scanner.next();

        listGroupMembersRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}
