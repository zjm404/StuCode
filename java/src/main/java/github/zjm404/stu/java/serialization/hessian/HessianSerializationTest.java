package github.zjm404.stu.java.serialization.hessian;

import github.zjm404.stu.java.serialization.IMessage;

import java.io.IOException;

/**
 * @Author zjm
 * @Date 2020/11/20
 * @Description
 * @Version 1.0
 */
public class HessianSerializationTest {
    public static void main(String[] args) throws IOException {
        MessageImplB messageImplB = new MessageImplB("hello world");
        byte[] bytes = HessianSerializationUtil.enSerialize(messageImplB);
        IMessage message = HessianSerializationUtil.deSerialize(bytes);
        message.say();
    }
}
