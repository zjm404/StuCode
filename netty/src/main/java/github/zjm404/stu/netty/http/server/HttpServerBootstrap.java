package github.zjm404.stu.netty.http.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class HttpServerBootstrap {
    public void start(int port) throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new HttpServerChannelInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = b.bind().sync();
            System.out.println("http server start , listen port: " + port);
            //线程进入 wait 状态，可以一直处于运行状态
            f.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
}
