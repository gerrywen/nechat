package com.gerrywen.nechat.demo.nettylogin.protocol.request;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import lombok.Data;

import static com.gerrywen.nechat.demo.nettylogin.protocol.command.Command.MESSAGE_REQUEST;
/**
 * @author wenguoli
 * @date 2020/1/15 17:37
 */
@Data
public class MessageRequestPacket extends Packet {

    /**
     * 发送消息
     */
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
