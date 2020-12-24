package github.zjm404.stu.demo.rpc.v2.protocol.serialization;

import java.io.*;

/**
 * @Author
 * @Date 2020/11/19
 * @Description
 * @Version 1.0
 */
public class JdkSerialization {
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        try(ObjectOutputStream oo = new ObjectOutputStream(bao)) {
            oo.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bao.toByteArray();
    }

    public <T> T deSerialize(byte[] bytes) {
        try(ObjectInputStream oi = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            return (T) oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
