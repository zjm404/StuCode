package github.zjm404.stu.netty.echo.server;

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
public class EchoServerBootstrap {
    private final int port;

    public EchoServerBootstrap(int port){
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    //指定所使用的 NIO 传输 Channel
                    .channel(NioServerSocketChannel.class)
                    //绑定端口
                    .localAddress(new InetSocketAddress(this.port))
                    .childHandler(new EchoServerChannelInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            //等待绑定服务器完成
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
            System.out.println("server 关闭");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //关闭 EventLoopGroup 释放所有资源
            group.shutdownGracefully().sync();
        }
    }
}
