/**
 * Author:   80303990
 * Date:     2020/10/27 19:09
 * Description: AIO的时间服务器
 */
package com.me.java.aio;

public class TimeServer {

    public static void main(String[] args) {
        int port=8080;
        AsyncTimeServerHandler timeServer=new AsyncTimeServerHandler(port);
        new Thread(timeServer,"AIO-TimeServer").start();
    }

}