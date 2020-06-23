package com.zzb.utils.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.WeakHashMap;

/**
 * @author 张志斌
 * @date 17:09 2020/5/6
 * @description
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    static final EventExecutorGroup eventGroup = new DefaultEventExecutorGroup(16);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("接收到数据" + byteBuf.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("ok", CharsetUtil.UTF_8));
        eventGroup.submit(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("execute线程为：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        PooledByteBufAllocator byteBufAllocator = new PooledByteBufAllocator();
        ByteBuf buffer = byteBufAllocator.buffer();
        buffer.discardReadBytes();
    }
}
