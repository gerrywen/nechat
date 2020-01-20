package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * program: nechat->JoinGroupRequestPacket
 * description: 加入群里
 * author: gerry
 * created: 2020-01-20 13:39
 **/
@Data
public class JoinGroupRequestPacket extends Packet {
    /**
     * 群ID
     */
    private String groupId;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
