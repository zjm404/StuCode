package cn.zjm404.stu.thread.stop.thread;

import java.util.concurrent.TimeUnit;

public class Client3 {
    public static void main(String[] args) throws InterruptedException {
        InterruptDemo2 demo = new InterruptDemo2();
        demo.run();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("开始终止");
        demo.stop();
        demo.getThread().join();
        System.out.println("终止成功");
    }
}
