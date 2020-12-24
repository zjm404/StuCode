package github.zjm404.stu.demo.rpc.v1.test;

import github.zjm404.stu.demo.rpc.v1.Consumer;
import github.zjm404.stu.demo.rpc.v1.IDemo;


/**
 * @Author
 * @Date 2020/11/6
 * @Description
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Consumer consumer = new Consumer(8080,"localhost");
        IDemo demo = consumer.recv();
        demo.sayHello();
    }
}
