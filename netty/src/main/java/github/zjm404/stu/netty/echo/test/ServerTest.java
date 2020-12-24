package github.zjm404.stu.netty.echo.test;

import github.zjm404.stu.netty.echo.server.EchoServerBootstrap;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class ServerTest {
    public static void main(String[] args) throws InterruptedException {
        new EchoServerBootstrap(8080).start();
    }
}
