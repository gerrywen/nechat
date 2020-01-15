package com.gerrywen.nechat.demo.nettylogin.protocol.command;

/**
 * @author wenguoli
 * @date 2020/1/15 14:54
 */
public interface Command {

    /**
     * 登录请求指令
     */
    Byte LOGIN_REQUEST = 1;

    /**
     * 登录响应指令
     */
    Byte LOGIN_RESPONSE = 2;

    /**
     * 发送消息指令
     */
    Byte MESSAGE_REQUEST = 3;

    /**
     * 接受消息指令
     */
    Byte MESSAGE_RESPONSE = 4;

}
