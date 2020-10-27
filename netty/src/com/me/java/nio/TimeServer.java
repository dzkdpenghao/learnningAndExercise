/**
 * Author:   80303990
 * Date:     2020/10/27 15:37
 * Description: NIO的时间服务器
 */
package com.me.java.nio;

public class TimeServer {
    public static void main(String[] args) {
        TimeServerHandler timeServer=new TimeServerHandler(8080);

        new Thread(timeServer,"NIO-TimeServer-01").start();
    }
}