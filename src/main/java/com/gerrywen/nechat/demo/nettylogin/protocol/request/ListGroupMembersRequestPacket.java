package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * program: nechat->ListGroupMembersRequestPacket
 * description: 群里列表成员
 * author: gerry
 * created: 2020-01-20 13:50
 **/
@Data
public class ListGroupMembersRequestPacket extends Packet {
    /**
     * 群里ID
     */
    private String groupId;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
