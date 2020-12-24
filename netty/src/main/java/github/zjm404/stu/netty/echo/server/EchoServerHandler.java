package github.zjm404.stu.netty.echo.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        //打印接收到的消息
        System.out.println("recv: " + byteBuf.toString(CharsetUtil.UTF_8));
        //发送消息给客户端
        ctx.write(byteBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将未决消息冲刷到远程节点，并关闭该 Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //打印异常栈跟踪
        cause.printStackTrace();
        //关闭该 Channel
        ctx.close();
    }
}
