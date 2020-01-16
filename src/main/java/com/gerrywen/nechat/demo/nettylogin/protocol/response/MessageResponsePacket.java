package com.gerrywen.nechat.demo.nettylogin.protocol.response;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.MESSAGE_RESPONSE;
/**
 * @author wenguoli
 * @date 2020/1/15 17:39
 */
@Data
public class MessageResponsePacket extends Packet {

    /**
     * 消息来源用户id
     */
    private String fromUserId;

    /**
     * 消息来源用户名称
     */
    private String fromUserName;


    /**
     * 响应回复消息
     */
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
