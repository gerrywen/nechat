package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * program: nechat->JoinGroupResponsePacket
 * description: 加入群里响应
 * author: gerry
 * created: 2020-01-20 13:52
 **/
@Data
public class JoinGroupResponsePacket extends Packet {

    /**
     * 标记是否成功
     */
    private boolean success;

    /**
     * 群聊ID
     */
    private String groupId;

    /**
     * 失败原因
     */
    private String reason;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}
