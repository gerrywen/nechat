package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * program: nechat->QuitGroupResponsePacket
 * description: 退出群里响应
 * author: gerry
 * created: 2020-01-20 13:54
 **/
@Data
public class QuitGroupResponsePacket extends Packet {


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
        return QUIT_GROUP_RESPONSE;
    }
}
