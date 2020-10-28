/**
 * Author:   80303990
 * Date:     2020/10/27 19:45
 * Description:
 */
package com.me.java.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel channel, AsyncTimeServerHandler handler) {
        //循环调用accept()，继续异步接收其他客户端
        handler.asynchronousServerSocketChannel.accept(handler,this);
        ByteBuffer rb=ByteBuffer.allocate(1024);
        channel.read(rb,rb,new ReadCompletionHandler(channel));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}