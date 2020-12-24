package github.zjm404.stu.netty.http.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class HttpServerChannelInitializer extends
        ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                //HTTP 编解码
                .addLast(new HttpServerCodec())
                //HTTPContent 压缩
                .addLast(new HttpContentCompressor())
                // HTTP消息聚合
                .addLast(new HttpObjectAggregator(65535))
                //自定义业务逻辑处理器
                .addLast(new HttpServerHandler());
    }
}
