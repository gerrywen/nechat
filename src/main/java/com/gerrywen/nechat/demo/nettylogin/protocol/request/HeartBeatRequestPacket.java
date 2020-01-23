package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * program: nechat->HeartBeatRequestPacket
 * description:
 * author: gerry
 * created: 2020-01-23 09:23
 **/
@Data
public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
