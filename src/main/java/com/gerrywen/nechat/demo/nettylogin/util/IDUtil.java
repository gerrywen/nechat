package com.gerrywen.nechat.demo.nettylogin.util;

import java.util.UUID;

/**
 * program: nechat->IDUtil
 * description: 随机数
 * author: gerry
 * created: 2020-01-20 09:50
 **/
public class IDUtil {

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
