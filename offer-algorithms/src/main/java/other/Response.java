package other;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-06-03 22:39
 **/
public class Response {
    OutputStream outputStream;

    public Response() {

    }

    Request request;

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void send(Object res) throws IOException {
        String body = res == null ? " Bad Request" : res.toString();//可以是html文件，读文本文件进来就行了
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Length: " + body.getBytes().length + "\r\n" +
                "Content-Type: text/html; charset-utf-8\r\n" +
                "\r\n" +
                body + "\r\n";
        outputStream.write(response.getBytes());
        outputStream.flush();
    }
}
