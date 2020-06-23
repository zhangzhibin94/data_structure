package com.zzb.utils.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * @author 张志斌
 * @date 20:32 2020/4/23
 * @description
 */
public class NioClientHandler implements Runnable{
    private Selector selector;
    private SocketChannel socketChannel;
    private InetSocketAddress remoteAddress = new InetSocketAddress("127.0.0.1", 8080);
    private static Boolean started;
    public NioClientHandler() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.bind(remoteAddress);
            // 开启非阻塞模式
            socketChannel.configureBlocking(false);
            started = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 往缓冲区写
     * @param msg
     */
    public void writeToBuffer(String msg){
        try {
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(msg.length());
        byteBuffer.put(msg.getBytes());
        try {
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() throws IOException {
        if(!socketChannel.connect(remoteAddress)){
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    @Override
    public void run() {
        try {
            connect();
            while (started){
                // 有读写事件发生,否则阻塞在这里
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(key -> {
                    selectionKeys.remove(key);
                    handleKey(key);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handleKey(SelectionKey key) {
        if(key.isValid() && key.isConnectable()){
            SocketChannel channel = (SocketChannel)key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            if(key.isReadable()){
                try {
                    int read = channel.read(byteBuffer);
                    if(read > 0){
                        byte[] bytes = new byte[byteBuffer.remaining()];
                        System.out.println(new String(bytes));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
