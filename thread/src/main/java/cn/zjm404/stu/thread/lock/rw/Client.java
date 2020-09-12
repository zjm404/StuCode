package cn.zjm404.stu.thread.lock.rw;

public class Client {
    public static void main(String[] args) {
        DowngradeLock downgradeLock = new DowngradeLock();
        Thread t1 = new Thread(()->{
            downgradeLock.demo();
        });
        Thread t2 = new Thread(()->{
            downgradeLock.demo();
        });
        t1.start();
        t2.start();
    }
}
