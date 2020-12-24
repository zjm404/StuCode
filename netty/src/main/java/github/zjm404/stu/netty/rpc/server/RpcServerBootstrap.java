package github.zjm404.stu.netty.rpc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class RpcServerBootstrap {
    public void start(int port) throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new RpcServerChannelInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
}
