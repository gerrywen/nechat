package com.gerrywen.nechat.demo.nettylogin.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * program: nechat->ConsoleCommand
 * description:
 * author: gerry
 * created: 2020-01-20 08:50
 **/
public interface ConsoleCommand {

    /**
     * 创建控制台命令执行器
     * @param scanner
     * @param channel
     */
    void exec(Scanner scanner, Channel channel);
}
