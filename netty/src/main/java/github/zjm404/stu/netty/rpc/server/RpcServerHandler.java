package github.zjm404.stu.netty.rpc.server;

import github.zjm404.stu.netty.rpc.common.JdkSerialization;
import github.zjm404.stu.netty.rpc.common.RpcRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.channels.SocketChannel;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class RpcServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        byte[] bytes = new JdkSerialization().serialize(new DemoImpl());
        channelHandlerContext.writeAndFlush(bytes);
    }
}
