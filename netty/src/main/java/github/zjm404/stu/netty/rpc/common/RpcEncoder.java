package github.zjm404.stu.netty.rpc.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author
 * @Date 2020/11/13
 * @Description
 * @Version 1.0
 */
public class RpcEncoder extends MessageToByteEncoder {
    private JdkSerialization serialization;
    public RpcEncoder(){
        this.serialization = new JdkSerialization();
    }
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] bytes = serialization.serialize(o);
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }
}
