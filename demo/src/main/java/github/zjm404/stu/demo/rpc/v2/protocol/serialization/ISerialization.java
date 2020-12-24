package github.zjm404.stu.demo.rpc.v2.protocol.serialization;

/**
 * @Author
 * @Date 2020/11/19
 * @Description
 * @Version 1.0
 */
public interface ISerialization {
    public <T> byte[] serialize(T obj);
    public <T> T deSerialize(byte[] bytes);
}
