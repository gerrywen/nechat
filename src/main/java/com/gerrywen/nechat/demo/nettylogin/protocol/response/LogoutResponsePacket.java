package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.LOGOUT_RESPONSE;

/**
 * program: nechat->LogoutResponsePacket
 * description:
 * author: gerry
 * created: 2020-01-20 09:04
 **/
@Data
public class LogoutResponsePacket extends Packet {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 失败原因
     */
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGOUT_RESPONSE;
    }
}
