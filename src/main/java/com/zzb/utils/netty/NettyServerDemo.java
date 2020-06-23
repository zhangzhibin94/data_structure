package com.zzb.utils.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.*;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author 张志斌
 * @date 22:09 2020/4/29
 * @description
 */
public class NettyServerDemo {
    private  static final InetSocketAddress ADDRESS = new InetSocketAddress("127.0.0.1", 9999);
    private  static final Integer BOSS_THREAD_NUMBER = Runtime.getRuntime().availableProcessors() * 2;
    private static final Integer WORK_THREAD_NUMBER = 100;
    static final EventExecutorGroup eventGroup = new DefaultEventExecutorGroup(16);
    public static void start(){
        EventLoopGroup bossThread = new NioEventLoopGroup(BOSS_THREAD_NUMBER);
        EventLoopGroup workThread = new NioEventLoopGroup(WORK_THREAD_NUMBER);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossThread, workThread)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY, false)
                /*.handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new IdleStateHandler(0,0,15, TimeUnit.SECONDS));
                    }
                })*/
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel){
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(eventGroup, new EchoServerHandler());
//                        pipeline.addLast(new LineBasedFrameDecoder(1024));
                        pipeline.addLast(new IdleStateHandler(0, 0, 7, TimeUnit.SECONDS));
                        /*pipeline.addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("$#", CharsetUtil.UTF_8)));
                        pipeline.addLast(new FixedLengthFrameDecoder(1024));
*/
                    }
                });
        try {
            bootstrap.bind(ADDRESS).sync();
            System.out.println("服务端创建成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NettyServerDemo.start();
    }
}
