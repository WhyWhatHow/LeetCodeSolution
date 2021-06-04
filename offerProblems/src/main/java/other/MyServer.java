package other;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import sun.security.provider.ConfigFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-06-03 21:53
 **/
public class MyServer {

    String address = "127.0.0.1";
    int port = 2222;
//    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args)  {
        MyServer server = new MyServer();// 可以通过构造方法传参
        System.out.println(" MyServer started ....");
        try {
            server.await();
        } catch (IOException e) {
        }

    }


    private void await() throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        Response response = null;
        Socket accept = null;
        System.out.println(" Myserver  accept Request ....");
        ServerSocket serverSocket = new ServerSocket(this.port, 1, InetAddress.getByName(this.address));
        while (true) {
            try {
                accept = serverSocket.accept();
                inputStream = accept.getInputStream();
                outputStream = accept.getOutputStream();
                // request 解析 uri
                Request request = new Request(inputStream);
                request.parse();
                // 执行业务逻辑
                Object result = doStringWithUri(request.getUri());
                // 返回response
                System.out.println(" Myserver Response here ............");
                response = new Response(outputStream);
                response.setRequest(request);
                response.send(result);
                System.out.println(" accept end ......");
            } catch (Exception e){
                response.send(e.getMessage());
            }
            finally {
                if (accept != null) {
                    accept.shutdownInput();
                    accept.shutdownOutput();
                    accept.close();
                }
            }
        }

    }
        private Object doStringWithUri (String uri){
            Expression ex = parseUri(uri);
            return ex==null?"Bad Request":ex.getRes();
            // // TODO: 2021/6/4   未解决 表达式为空的状况,
        }

        static String OP_ADD = "add";
        static String OP_MULT = "mult";

        private Expression parseUri (String uri){
            Expression ex = new Expression();
            if (uri.indexOf("add") != -1) {
                ex.setOp(OP_ADD);
            } else if (uri.indexOf(OP_MULT) != -1) {
                ex.setOp(OP_MULT);
            } else {
                return null;
            }
            String[] split = uri.split("=");
            ex.setB(Integer.valueOf(split[2]));
            String[] strings = split[1].split("&");
            ex.setA(Integer.valueOf(strings[0]));
            return ex;
        }

    }
