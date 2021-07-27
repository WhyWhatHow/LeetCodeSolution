package server;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-07-22 11:17
 **/
public class NIOServerSelectorThread {
    ServerSocketChannel serverSocketChannel=null;
    ServerSocket serverSocket =null;
    Selector selector ;
    public NIOServerSelectorThread(int port)
    {
        try {
            //打开ServerSocketChannel，用于监听客户端的连接，他是所有客户端连接的父管道
            serverSocketChannel = ServerSocketChannel.open();
            //将管道设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //利用ServerSocketChannel创建一个服务端Socket对象，即ServerSocket
            serverSocket = serverSocketChannel.socket();
            //为服务端Socket绑定监听端口
            serverSocket.bind(new InetSocketAddress(port));
            //创建多路复用器
            selector = Selector.open();
            //将ServerSocketChannel注册到Selector多路复用器上，并且监听ACCEPT事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The server is start in port: "+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NIOServerSelectorThread server =new NIOServerSelectorThread(8888);

    }
}



