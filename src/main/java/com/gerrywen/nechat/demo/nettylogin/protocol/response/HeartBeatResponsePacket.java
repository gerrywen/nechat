package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * program: nechat->HeartBeatResponsePacket
 * description:
 * author: gerry
 * created: 2020-01-23 09:24
 **/
@Data
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
