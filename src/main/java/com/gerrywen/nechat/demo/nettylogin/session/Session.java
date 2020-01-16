package com.gerrywen.nechat.demo.nettylogin.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wenguoli
 * @date 2020/1/16 15:36
 */
@Data
@NoArgsConstructor
public class Session {
    // 用户唯一性标识
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }

}
