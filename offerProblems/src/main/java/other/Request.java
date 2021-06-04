package other;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-06-03 22:39
 **/
public class Request {
    InputStream inputStream;
    String uri;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Request() {
    }

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        StringBuffer buf = new StringBuffer(2048);
        int read = 0;
        byte[] buffer = new byte[2048];
        try {
            read = inputStream.read(buffer);
        } catch (IOException e) {
            read =-1;
        }
        for (int i = 0; i < read; i++) {
             buf.append((char)buffer[i]);
        }

        System.out.println( buf.toString());
        uri = parseUri(buf.toString());


    }
    /**
     *
     * requestString形式如下：
     * GET /index.html HTTP/1.1
     * Host: localhost:8080
     * Connection: keep-alive
     * Cache-Control: max-age=0
     * ...
     * 该函数目的就是为了获取/index.html字符串
     */
    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;
    }

}
