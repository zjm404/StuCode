package cn.zjm404.stu.thread.stop.thread;

import cn.zjm404.stu.thread.stop.thread.CannotInterruptDemo;

import java.util.concurrent.TimeUnit;

public class Client2 {
    public static void main(String[] args) throws InterruptedException {
        CannotInterruptDemo demo = new CannotInterruptDemo();
        demo.run();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("开始终止");
        demo.stop();
        demo.getThread().join();
    }
}
