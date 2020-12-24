package github.zjm404.stu.netty.rpc.server;

import github.zjm404.stu.netty.rpc.common.RpcDecoder;
import github.zjm404.stu.netty.rpc.common.RpcEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.json.JsonObjectDecoder;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class RpcServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast(new LengthFieldBasedFrameDecoder(65535,0,4))
                .addLast(new RpcEncoder())
                .addLast(new RpcDecoder())
                .addLast(new RpcServerHandler());
    }
}
