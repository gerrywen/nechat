package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import com.gerrywen.nechat.demo.nettylogin.session.Session;
import lombok.Data;

import java.util.List;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * program: nechat->ListGroupMembersResponsePacket
 * description: 群列表响应
 * author: gerry
 * created: 2020-01-20 13:56
 **/
@Data
public class ListGroupMembersResponsePacket extends Packet {

    /**
     * 群ID
     */
    private String groupId;

    /**
     * 记录加入群的成员
     */
    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
