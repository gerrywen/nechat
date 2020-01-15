package com.gerrywen.nechat.demo.nettylogin.util;

import com.gerrywen.nechat.demo.nettylogin.attribute.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author wenguoli
 * @date 2020/1/15 17:41
 */
public class LoginUtil {

    /**
     * 设置登录属性
     * @param channel
     */
    public static void markAsLogin(Channel channel) {
        // 设置登录属性
        channel.attr(Attributes.LOGIN).set(true);
    }

    /**
     * 校验登录属性
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }

}
