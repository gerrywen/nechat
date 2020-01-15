package com.gerrywen.nechat.demo.protocol.protocol.command;

import lombok.Data;

import static com.gerrywen.nechat.demo.protocol.protocol.command.Command.LOGIN_REQUEST;

/**
 * 定义登录请求数据包
 * @author wenguoli
 * @date 2020/1/15 10:52
 */
@Data
public class LoginRequestPacket extends Packet {

    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
