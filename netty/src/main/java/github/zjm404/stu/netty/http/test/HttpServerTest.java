package github.zjm404.stu.netty.http.test;

import github.zjm404.stu.netty.http.server.HttpServerBootstrap;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class HttpServerTest {
    public static void main(String[] args) throws InterruptedException {
        new HttpServerBootstrap().start(8080);
    }
}
