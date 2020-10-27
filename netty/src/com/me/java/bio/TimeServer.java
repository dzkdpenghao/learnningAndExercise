/**
 * Author:   80303990
 * Date:     2020/10/27 14:36
 * Description: BIO的时间服务器
 */
package com.me.java.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The time server is started in port:" + port);
            Socket socket = null;

            while (true) {
                socket = server.accept();

                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
