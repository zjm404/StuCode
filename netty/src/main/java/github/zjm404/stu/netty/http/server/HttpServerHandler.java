package github.zjm404.stu.netty.http.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        String content = String.format("Receive http request, uri: %s, method: %s, content: %s%n", fullHttpRequest.uri(),fullHttpRequest.method(),fullHttpRequest.content().toString(CharsetUtil.UTF_8));
        HttpVersion version;
        HttpResponseStatus status;
        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(content.getBytes()));
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
