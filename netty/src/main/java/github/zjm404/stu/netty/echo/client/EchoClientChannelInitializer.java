package github.zjm404.stu.netty.echo.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class EchoClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new EchoClientHandler());
    }
}
