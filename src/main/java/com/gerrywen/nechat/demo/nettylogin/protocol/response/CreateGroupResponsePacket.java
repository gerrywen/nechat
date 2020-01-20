package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * program: nechat->CreateGroupResponsePacket
 * description: 创建群聊响应
 * author: gerry
 * created: 2020-01-20 09:05
 **/
@Data
public class CreateGroupResponsePacket extends Packet {
    /**
     * 标记是否成功
     */
    private boolean success;

    /**
     * 群聊ID
     */
    private String groupId;

    /**
     * 用户名list
     */
    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}
