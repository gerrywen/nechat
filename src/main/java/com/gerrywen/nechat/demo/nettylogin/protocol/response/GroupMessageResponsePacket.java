package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import com.gerrywen.nechat.demo.nettylogin.session.Session;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * program: nechat->GroupMessageResponsePacket
 * description:
 * author: gerry
 * created: 2020-01-21 20:55
 **/
@Data
public class GroupMessageResponsePacket extends Packet {

    /**
     * 来自群ID
     */
    private String fromGroupId;

    /**
     * 发消息用户
     */
    private Session fromUser;

    /**
     * 发送的消息
     */
    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
