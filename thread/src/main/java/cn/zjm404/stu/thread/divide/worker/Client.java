package cn.zjm404.stu.thread.divide.worker;

import java.util.concurrent.LinkedBlockingQueue;

public class Client {
    public static void main(String[] args) {
        //设置任务阻塞队列
        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(8);
        //设置线程数为 6
        WorkerThreadTest wt = new WorkerThreadTest(workQueue,6);
        wt.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });
    }
}
