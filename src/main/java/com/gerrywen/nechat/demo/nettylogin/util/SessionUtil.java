package com.gerrywen.nechat.demo.nettylogin.util;

import com.gerrywen.nechat.demo.nettylogin.attribute.Attributes;
import com.gerrywen.nechat.demo.nettylogin.session.Session;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wenguoli
 * @date 2020/1/16 15:37
 */
public class SessionUtil {

    /**
     * 线程安全且高效的HashMap实现
     */
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel) {

        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {

        return userIdChannelMap.get(userId);
    }
}
