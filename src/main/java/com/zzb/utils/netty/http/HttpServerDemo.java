package com.zzb.utils.netty.http;

import com.zzb.utils.netty.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author 张志斌
 * @date 20:07 2020/5/7
 * @description
 */
public class HttpServerDemo {
    private  static final InetSocketAddress ADDRESS = new InetSocketAddress("127.0.0.1", 9999);
    private  static final Integer BOSS_THREAD_NUMBER = Runtime.getRuntime().availableProcessors() * 2;
    private static final Integer WORK_THREAD_NUMBER = 100;
    public static void start(){
        EventLoopGroup bossThread = new NioEventLoopGroup(BOSS_THREAD_NUMBER);
        EventLoopGroup workThread = new NioEventLoopGroup(WORK_THREAD_NUMBER);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossThread, workThread)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY, false)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel){
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new HttpServerInitHandler());
                    }
                });
        try {
            bootstrap.bind(ADDRESS).sync();
            System.out.println("服务端创建成功,ip为：" + ADDRESS.getHostName() +", 端口号为：" + ADDRESS.getPort());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpServerDemo.start();
    }
}
