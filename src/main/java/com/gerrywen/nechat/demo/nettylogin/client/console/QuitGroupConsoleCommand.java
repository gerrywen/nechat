package com.gerrywen.nechat.demo.nettylogin.client.console;

import com.gerrywen.nechat.demo.nettylogin.protocol.request.QuitGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * program: nechat->QuitGroupConsoleCommand
 * description: 群退出命令
 * author: gerry
 * created: 2020-01-20 14:13
 **/
public class QuitGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();

        System.out.print("输入 groupId，退出群聊：");
        String groupId = scanner.next();

        quitGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(quitGroupRequestPacket);
    }
}
