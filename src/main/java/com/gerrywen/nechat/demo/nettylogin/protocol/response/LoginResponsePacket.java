package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.LOGIN_RESPONSE;

/**
 * 登录响应包
 * @author wenguoli
 * @date 2020/1/15 14:57
 */
@Data
public class LoginResponsePacket extends Packet {

    private String userId;

    private String userName;


    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
