/**
 * Author:   80303990
 * Date:     2020/10/27 20:06
 * Description: AIO的时间客户端
 */
package com.me.java.aio;

public class TimeClient {
    public static void main(String[] args) {
        int port=8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"AIO-TimeClient").start();
    }
}