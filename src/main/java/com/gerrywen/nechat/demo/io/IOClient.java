package com.gerrywen.nechat.demo.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author wenguoli
 * @date 2020/1/14 14:45
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {

            try {
                Socket socket = new Socket("127.0.0.1", 4000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
