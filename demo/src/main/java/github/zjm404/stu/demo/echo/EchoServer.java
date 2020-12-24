package github.zjm404.stu.demo.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 监听和接收进来的连接请求
 * 配置Channel来通知一个关于入站消息的EchoServerHandler实例
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port){
        this.port = port;
    }
    public void start() throws Exception{
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //创建EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();
        try{
            //创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    //指定使用的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    //添加一个EchoServerHandler到子Channel的ChannelPipeline
                    .childHandler(
                            //当一个新的连接被接受时，一个新的子Channel将会被创建
                            new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            //异步地绑定服务器；调用sync()方法阻塞等待直到绑定完成
            ChannelFuture f = b.bind().sync();
            //获取Channel的CloseFuture,并且阻塞当前线程直到它完成
            f.channel().closeFuture().sync();
        }finally {
            //关闭EventLoopGroup,释放所有资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
//        if(args.length != 1){
//            System.out.println("Usage：" + EchoServer.class.getSimpleName() + "<port>");
//        }
//        int port = Integer.parseInt(args[0]);
        int port = 8080;
        new EchoServer(port).start();
    }
}
