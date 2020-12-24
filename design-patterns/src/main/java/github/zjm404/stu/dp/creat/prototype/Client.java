package github.zjm404.stu.dp.creat.prototype;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProtoType protoType = new ProtoType();
        protoType.setMsg1(new MsgObject(1,"hello world"));
        System.out.println("protoType: " + protoType.toString());
        ProtoType protoType1 = protoType.deepClone();
        protoType1.getMsg1().setMsg("HELLO WORLD");
        System.out.println("protoType1: " + protoType1.toString());
        System.out.println("protoType: " + protoType.toString());
    }
}
