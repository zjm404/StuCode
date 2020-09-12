package cn.zjm404.stu.thread.correspond.inner;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread c1 = new Thread(new Consumer(resource));
        Thread p1 = new Thread(new Producer(resource));

        c1.start();
        p1.start();
        c1.join();
        p1.join();
    }

}
