package com.zzb.utils.concurrency.cas;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author 张志斌
 * @date 15:53 2020/3/3
 * @description
 */
public class MineAQS {
    public static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            return false;
        }
    }

    private static Sync sync = new Sync();

    public static void main(String[] args) {
        /*try {

            AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
            channel.bind(new InetSocketAddress("127.0.0.1",80));
            channel.setOption(StandardSocketOptions.SO_KEEPALIVE, Boolean.TRUE);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.write(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {

                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });

            AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",80));
            serverSocketChannel.accept(this, new CompletionHandler<AsynchronousSocketChannel, MineAQS>() {
                @Override
                public void completed(AsynchronousSocketChannel result, MineAQS attachment) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    result.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {

                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {

                        }
                    });
                }

                @Override
                public void failed(Throwable exc, MineAQS attachment) {

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs == null || strs.length == 0){
            return result;
        }
        int point = 0;
        String target = strs[0];
        while(point < target.length()){
            for(int i = 1; i < strs.length; i++){
                if(strs[i].length() <= point || (strs[i].charAt(point) != target.charAt(point))){
                    return result;
                }
            }
            result += target.charAt(point) + "";
            point++;
        }
        return result;
    }
}
