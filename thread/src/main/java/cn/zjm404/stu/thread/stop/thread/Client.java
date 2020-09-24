package cn.zjm404.stu.thread.stop.thread;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        InterruptDemo demo = new InterruptDemo();
        demo.run();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("开始终止任务");
        demo.stop();
    }
}
