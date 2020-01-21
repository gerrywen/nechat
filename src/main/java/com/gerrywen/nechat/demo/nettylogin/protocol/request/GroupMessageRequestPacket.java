package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.GROUP_MESSAGE_REQUEST;

/**
 * program: nechat->GroupMessageRequestPacket
 * description:
 * author: gerry
 * created: 2020-01-21 20:52
 **/
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {

    /**
     * 群ID
     */
    private String toGroupId;

    /**
     * 发送消息
     */
    private String message;


    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
