package com.gerrywen.nechat.demo.nettylogin.attribute;

import io.netty.util.AttributeKey;

/**
 * @author wenguoli
 * @date 2020/1/15 17:42
 */
public interface Attributes {
    /**
     * 登录属性
     */
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
