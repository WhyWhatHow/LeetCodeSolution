package other;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-06-04 12:26
 **/
public class HttpThread  extends Thread{
    InputStream inputStream = null;
    OutputStream outputStream = null;
    Response response =null;
    Socket accept =null;

    public void run(){

//        inputStream = accept.getInputStream();
//        outputStream = accept.getOutputStream();
//        // request 解析 uri
//        Request request = new Request(inputStream);
//        request.parse();
//        // 执行业务逻辑
//        Integer result = doStringWithUri(request.getUri());
//        // 返回response
//        System.out.println(" Myserver Response here ............");
//        response = new Response(outputStream);
//        response.setRequest(request);
//        response.send(result);
//
//        System.out.println(" accept end ......");
    }

}
