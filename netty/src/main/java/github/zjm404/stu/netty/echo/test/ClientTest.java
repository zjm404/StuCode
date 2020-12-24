package github.zjm404.stu.netty.echo.test;

import github.zjm404.stu.netty.echo.client.EchoClientBootstrap;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class ClientTest {
    public static void main(String[] args) throws InterruptedException {
        new EchoClientBootstrap("localhost",8080).start();
    }
}
