package com.gerrywen.nechat.demo.nettylogin.serialize;

import com.gerrywen.nechat.demo.nettylogin.serialize.impl.JSONSerializer;

/**
 * @author wenguoli
 * @date 2020/1/15 10:56
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
