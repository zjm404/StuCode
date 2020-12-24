package github.zjm404.stu.demo.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * 连接到服务器
 * 发送一个或者多个消息
 * 对于每个消息，等待并接收从服务器发回的相同的消息
 * 关闭连接
 */
public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host,int port){
        this.host = host;
        this.port = port;
    }
    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            //创建Bootstrap
            Bootstrap b = new Bootstrap();
            //指定EventLoopGroup以处理客户端事件，需要适合NIO的实现
            b.group(group)
                    //适合于NIO传输的Channel类型
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            //连接到远程节点，阻塞等待直到连接完成
            ChannelFuture f = b.connect().sync();
            //阻塞，直到Channel关闭
            f.channel().closeFuture().sync();
        }finally {
            //关闭线程池并且释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
//        if(args.length != 2){
//            System.out.println("Usage: " + EchoClient.class.getSimpleName() + "<host> <port>");
//            return;
//        }
//        String host = args[0];
//        int port = Integer.parseInt(args[1]);
        String host = "localhost";
        int port = 8080;
        new EchoClient(host,port).start();

    }
}
