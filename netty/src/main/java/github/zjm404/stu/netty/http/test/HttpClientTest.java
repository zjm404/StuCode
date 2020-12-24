package github.zjm404.stu.netty.http.test;

import github.zjm404.stu.netty.http.client.HttpClientBootstrap;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class HttpClientTest {
    public static void main(String[] args) throws Exception {
        new HttpClientBootstrap().start("127.0.0.1",8080);
    }
}
