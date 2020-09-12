package cn.zjm404.stu.thread.safe;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(()->{
            synchronized (o1){
                try {
                    //为了增大死锁的概率，等等另一个线程
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("t1");
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (o2){
                synchronized (o1){
                    System.out.println("t2");
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
