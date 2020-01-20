package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * program: nechat->QuitGroupRequestPacket
 * description: 退出群聊请求
 * author: gerry
 * created: 2020-01-20 13:43
 **/
@Data
public class QuitGroupRequestPacket extends Packet {

    /**
     * 群里ID
     */
    private String groupId;


    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}
