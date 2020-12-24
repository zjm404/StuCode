package github.zjm404.stu.netty.http.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class HttpClientBootstrap {
    public void start(String host,int port) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE,true);
            b.handler(new HttpClientChannelInitializer());
            ChannelFuture f = b.connect(host,port).sync();
            URI uri = new URI("http://127.0.0.1:8080");
            String content = "hello world";
            DefaultFullHttpRequest request = new DefaultFullHttpRequest(
                    HttpVersion.HTTP_1_1, HttpMethod.GET, uri.toASCIIString(), Unpooled.wrappedBuffer(content.getBytes(StandardCharsets.UTF_8)));
            request.headers().set(HttpHeaderNames.HOST,host);
            request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            request.headers().set(HttpHeaderNames.CONTENT_LENGTH,request.content().readableBytes());
            f.channel().write(request);
            f.channel().flush();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }
}
