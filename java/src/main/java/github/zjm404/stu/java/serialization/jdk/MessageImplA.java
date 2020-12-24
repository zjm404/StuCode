package github.zjm404.stu.java.serialization.jdk;

import github.zjm404.stu.java.serialization.IMessage;

import java.io.Serializable;

/**
 * @Author zjm
 * @Date 2020/11/20
 * @Description
 * @Version 1.0
 */
public class MessageImplA implements IMessage, Serializable {


    private static final long serialVersionUID = 5546302531990288147L;
    private String msg;
    public MessageImplA(String msg){
        this.msg = msg;
    }
    @Override
    public void say() {
        System.out.println(msg);
    }
}
