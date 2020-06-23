package com.zzb.utils.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;

/**
 * @author 张志斌
 * @date 17:17 2020/5/6
 * @description
 */
public class NettyClientDemo {
    private  static final InetSocketAddress ADDRESS = new InetSocketAddress("127.0.0.1", 9999);
    public static void start(){
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new EchoClientHandler())
                                .addLast(new MessageEncoder())
                                //在包前面声明数据的长度 参数为:长度字段占的字节数(一字节等于8位) 一般用于客户端
                                .addLast(new LengthFieldPrepender(2))
                                // 在服务端需要将长度字段从数据包中分离出来
                                // 参数:包的最大长度,长度字段在字节流中的偏移量,长度所占字节(与客户端定义的长度保持一致),数据包长度-数据长度-长度的所占字节长度-长度字节的偏移量,读取数据的从第几个字节开始读取
                                .addLast(new LengthFieldBasedFrameDecoder(65535,0, 2, 0, 2));
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect(ADDRESS).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++){
            NettyClientDemo.start();
        }

    }
}
