package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * program: nechat->CreateGroupRequestPacket
 * description: 加入群请求包
 * author: gerry
 * created: 2020-01-20 09:00
 **/
@Data
public class CreateGroupRequestPacket extends Packet {

    /**
     * 记录加入群的用户ID
     */
    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}
