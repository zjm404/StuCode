package github.zjm404.stu.java.serialization.jdk;


import github.zjm404.stu.java.serialization.IMessage;


/**
 * @Author zjm
 * @Date 2020/11/20
 * @Description
 * @Version 1.0
 */
public class JdkSerializationTest {
    public static void main(String[] args) {
        MessageImplA messageImplA = new MessageImplA("hello world");
        byte[] bytes = JdkSerializationUtil.enSerialize(messageImplA);
        IMessage msg = JdkSerializationUtil.deSerialize(bytes);
        msg.say();
    }
}
