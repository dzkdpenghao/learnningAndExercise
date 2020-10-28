/**
 * Author:   80303990
 * Date:     2020/10/28 16:04
 * Description:
 */
package com.me.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.util.Date;

public class TimeServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf rb= (ByteBuf) msg;
        byte[] req=new byte[rb.readableBytes()];
        rb.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("The time server received order:"+body);
        String currentTime="QUERY TIME ORDER".equals(body)?
                new Date(System.currentTimeMillis()).toString()
                :"BAD ORDER";
        ByteBuf wb= Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(wb);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}