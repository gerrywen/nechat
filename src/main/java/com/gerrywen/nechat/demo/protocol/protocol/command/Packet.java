package com.gerrywen.nechat.demo.protocol.protocol.command;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 定义通信过程中的 Java 对象
 * @author wenguoli
 * @date 2020/1/15 10:43
 */
@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();
}
