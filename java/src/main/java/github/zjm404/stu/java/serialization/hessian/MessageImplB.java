package github.zjm404.stu.java.serialization.hessian;

import github.zjm404.stu.java.serialization.IMessage;

import java.io.Serializable;

/**
 * @Author zjm
 * @Date 2020/11/20
 * @Description
 * @Version 1.0
 */
public class MessageImplB implements IMessage, Serializable {
    private String msg;
    private final String FLAG = "hessian: ";
    public MessageImplB(String msg){
        this.msg = msg;
    }
    @Override
    public void say() {
        System.out.println(FLAG + msg);
    }
}
