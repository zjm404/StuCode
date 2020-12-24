package github.zjm404.stu.netty.rpc.server;

import github.zjm404.stu.netty.rpc.api.IDemo;

/**
 * @Author
 * @Date 2020/11/11
 * @Description
 * @Version 1.0
 */
public class DemoImpl implements IDemo {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
