package com.zzb.utils.netty.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author 张志斌
 * @date 20:24 2020/5/7
 * @description
 */
public class BusinessHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request = (FullHttpRequest) msg;
        String uri = request.uri();
        HttpMethod method = request.method();
        if(method.equals(HttpMethod.GET)){
            String content = request.content().toString(CharsetUtil.UTF_8);
            System.out.println("请求路径为：" + uri + ",内容为：" + content);
            sendMsg(ctx, "hello afavgaw", HttpResponseStatus.OK);
            request.release();
        }

    }

    public void sendMsg(ChannelHandlerContext ctx, String msg, HttpResponseStatus status){
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                status, Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
