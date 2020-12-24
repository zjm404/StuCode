package github.zjm404.stu.netty.rpc.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.ibatis.reflection.Jdk;
import org.springframework.core.serializer.support.SerializationDelegate;

import java.util.List;

/**
 * @Author
 * @Date 2020/11/13
 * @Description
 * @Version 1.0
 */
public class RpcDecoder extends ByteToMessageDecoder {
    private JdkSerialization serialization;
    public RpcDecoder(){
        this.serialization = new JdkSerialization();
    }
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if(byteBuf.readableBytes() < 4){
            return;
        }
        byteBuf.markReaderIndex();
        int dataLength = byteBuf.readInt();
        if(byteBuf.readableBytes() < dataLength){
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        byteBuf.readBytes(data);
        Object obj = serialization.deSerialize(data);
        list.add(obj);
    }
}
