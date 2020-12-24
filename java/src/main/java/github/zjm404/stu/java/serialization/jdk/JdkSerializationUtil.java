package github.zjm404.stu.java.serialization.jdk;

import java.io.*;

/**
 * @Author zjm
 * @Date 2020/11/20
 * @Description
 * @Version 1.0
 */
public class JdkSerializationUtil {
    public static  <T> T deSerialize(byte[] bytes){
        T res = null;
        try(InputStream in = new ByteArrayInputStream(bytes);ObjectInputStream ois = new ObjectInputStream(in)){
            res = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static <T>byte[] enSerialize(T obj){
        byte[] res = null;
        try(ByteArrayOutputStream bao = new ByteArrayOutputStream();ObjectOutputStream oos = new ObjectOutputStream(bao);){
            oos.writeObject(obj);
            res = bao.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
