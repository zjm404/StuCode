package cn.zjm404.stu.demo.timing;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world" + System.currentTimeMillis());
            }
        };
        TimedTaskDemo.doTask(r, 0, 10, TimeUnit.SECONDS);
        Thread.yield();
    }
}
