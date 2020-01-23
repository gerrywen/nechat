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

    /**
     * 退出请求指令
     */
    Byte LOGOUT_REQUEST = 5;

    /**
     * 退出响应指令
     */
    Byte LOGOUT_RESPONSE = 6;

    /**
     * 创建群聊请求指令
     */
    Byte CREATE_GROUP_REQUEST = 7;

    /**
     * 创建群聊响应指令
     */
    Byte CREATE_GROUP_RESPONSE = 8;

    /**
     * 群里列表请求指令
     */
    Byte LIST_GROUP_MEMBERS_REQUEST = 9;

    /**
     * 群里列表响应指令
     */
    Byte LIST_GROUP_MEMBERS_RESPONSE = 10;

    /**
     * 加入群里请求指令
     */
    Byte JOIN_GROUP_REQUEST = 11;

    /**
     * 加入群里响应指令
     */
    Byte JOIN_GROUP_RESPONSE = 12;

    /**
     * 退出群里请求指令
     */
    Byte QUIT_GROUP_REQUEST = 13;

    /**
     * 退出群里响应指令
     */
    Byte QUIT_GROUP_RESPONSE = 14;

    /**
     * 发送群聊请求指令
     */
    Byte GROUP_MESSAGE_REQUEST = 15;

    /**
     * 发送群聊响应指令
     */
    Byte GROUP_MESSAGE_RESPONSE = 16;

    /**
     * 心跳请求指令
     */
    Byte HEARTBEAT_REQUEST = 17;

    /**
     * 心跳响应指令
     */
    Byte HEARTBEAT_RESPONSE = 18;
}
