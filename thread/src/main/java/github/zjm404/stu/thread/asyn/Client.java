package github.zjm404.stu.thread.asyn;

import java.util.concurrent.ExecutionException;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TeaDemo teaDemo = new TeaDemo();
        teaDemo.doSomething();
    }
}
