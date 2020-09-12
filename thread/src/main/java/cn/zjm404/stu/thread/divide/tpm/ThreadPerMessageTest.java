package cn.zjm404.stu.thread.divide.tpm;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 一个任务一个线程
 */
public class ThreadPerMessageTest {
    public synchronized void run(Runnable work){
            new Thread(work).start();
    }
}
