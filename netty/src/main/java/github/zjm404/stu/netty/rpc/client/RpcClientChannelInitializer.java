package github.zjm404.stu.netty.rpc.client;

import github.zjm404.stu.netty.rpc.common.RpcDecoder;
import github.zjm404.stu.netty.rpc.common.RpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class RpcClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new RpcDecoder())
                .addLast(new RpcEncoder())
                .addLast(new RpcClientHandler());
    }
}
