package com.gerrywen.nechat.demo.protocol.protocol.command;

import com.gerrywen.nechat.demo.nettylogin.protocol.Packet;
import com.gerrywen.nechat.demo.nettylogin.protocol.PacketCodeC;
import com.gerrywen.nechat.demo.nettylogin.protocol.request.LoginRequestPacket;
import com.gerrywen.nechat.demo.nettylogin.serialize.Serializer;
import com.gerrywen.nechat.demo.nettylogin.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * @author wenguoli
 * @date 2020/1/15 11:24
 */
public class PacketCodeCTest {

    @Test
    public void encode() {
        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = PacketCodeC.INSTANCE;
        ByteBuf byteBuf = packetCodeC.encode(ByteBufAllocator.DEFAULT, loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));
    }
}
