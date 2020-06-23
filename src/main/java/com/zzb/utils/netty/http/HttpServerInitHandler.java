package com.zzb.utils.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author 张志斌
 * @date 20:08 2020/5/7
 * @description
 */
public class HttpServerInitHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ch.pipeline()
                // 对响应编码
                .addLast("encode", new HttpResponseEncoder())
                // 对请求解码
                .addLast("decode", new HttpRequestDecoder())
                // 聚合器，把多个消息转换为一个单一的FullHttpRequest或是FullHttpResponse
                .addLast("aggregator", new HttpObjectAggregator(1024 * 1024))
                // 压缩
                .addLast("compressor", new HttpContentCompressor())
                .addLast("business", new BusinessHandler());

    }
}
