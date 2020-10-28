/**
 * Author:   80303990
 * Date:     2020/10/27 20:07
 * Description:
 */
package com.me.java.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements Runnable, CompletionHandler<Void,AsyncTimeClientHandler> {

    private String host;
    private int port;
    private AsynchronousSocketChannel asynchronousSocketChannel;
    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host=host;
        this.port=port;

        try {
            asynchronousSocketChannel=AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch=new CountDownLatch(1);
        asynchronousSocketChannel.connect(new InetSocketAddress(host,port),this,this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            asynchronousSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] req="QUERY TIME ORDER".getBytes();
        ByteBuffer wb=ByteBuffer.allocate(req.length);
        wb.put(req);
        wb.flip();
        asynchronousSocketChannel.write(wb, wb,
                new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment1) {
                        if(attachment1.hasRemaining()){
                           asynchronousSocketChannel.write(attachment1,attachment1,this);
                        }else {
                            ByteBuffer rb=ByteBuffer.allocate(1024);
                            asynchronousSocketChannel.read(rb, rb,
                                    new CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer result, ByteBuffer attachment2) {
                                            attachment2.flip();
                                            byte[] bytes=new byte[attachment2.remaining()];
                                            attachment2.get(bytes);
                                            String body;
                                            try {
                                                body=new String(bytes,"UTF-8");
                                                System.out.println("Now is:"+body);
                                                latch.countDown();
                                            } catch (UnsupportedEncodingException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        @Override
                                        public void failed(Throwable exc, ByteBuffer attachment) {
                                            try {
                                                asynchronousSocketChannel.close();
                                                latch.countDown();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        try {
                            asynchronousSocketChannel.close();
                            latch.countDown();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        exc.printStackTrace();
        try {
            asynchronousSocketChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}