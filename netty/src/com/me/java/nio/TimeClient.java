/**
 * Author:   80303990
 * Date:     2020/10/27 16:18
 * Description: AIO的时间客户端
 */
package com.me.java.nio;

public class TimeClient {
    public static void main(String[] args) {
        new Thread(new TimeClientHandler("127.0.0.1",8080),"AIO-TimeClient").start();
    }
}