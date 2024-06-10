package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-05-17 11:23
 **/

public class AsyncChannelDemo {
    // main thread wait until complete
    public static final CountDownLatch EXIT_LATCH = new CountDownLatch(1);
    // current server's SocketChannel
    public static AsynchronousServerSocketChannel serverSocketChannel;
    // current connected client socket
    public static AsynchronousSocketChannel curClientSocket;
    // create our SocketChannel via port
    public static void createAsynchronousServerSocketChannel(int port) {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // when we complete,we must close server and make main thread end
    public static void closeServer() {
        System.out.println("close aio server");
        try {
            if (curClientSocket != null) {
                curClientSocket.close();
            }
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // notify main thread
        EXIT_LATCH.countDown();
    }
    // handle client data
    public static class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {
        @Override
        public void completed(Integer result, ByteBuffer buffer) {
            // now buffer is our need data from client
            System.out.println(new String(buffer.array()));
            // close server
            closeServer();
        }
        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            exc.printStackTrace();
            closeServer();
        }
    }
    // handle server accept client request
    public static class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object>{
        @Override
        public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
            System.out.println("receive result:" + socketChannel.toString());
            // now result is socket from client that's your browser
            // we can read some data using handler
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            socketChannel.read(byteBuffer, byteBuffer, new ReadHandler());
            curClientSocket = socketChannel;
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            exc.printStackTrace();
            closeServer();
        }
    }
    public static void main(String[] args) {
        System.out.println("start aio server");
        createAsynchronousServerSocketChannel(8888);
        serverSocketChannel.accept(null, new AcceptHandler());
        // main thread wait exit
        try {
            System.out.println("wait server close");
            EXIT_LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end aio server");
    }
}