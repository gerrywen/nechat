package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.LOGOUT_REQUEST;

/**
 * program: nechat->LogoutRequestPacket
 * description: 退出请求包
 * author: gerry
 * created: 2020-01-20 08:59
 **/
@Data
public class LogoutRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}
