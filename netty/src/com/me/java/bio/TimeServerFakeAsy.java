/**
 * Author:   80303990
 * Date:     2020/10/27 15:15
 * Description: 使用线程池的伪异步时间服务器
 */
package com.me.java.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerFakeAsy {
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

class TimeServerHandlerExcutePoll {
    private ExecutorService excutor;

    public TimeServerHandlerExcutePoll(int maxPollSize, int queueSize) {
        excutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPollSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void excute(Runnable task){
        excutor.execute(task);
    }
}