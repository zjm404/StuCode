package github.zjm404.stu.thread.lock.explicition;

public class Client {
    public static void main(String[] args) {
        ReentrantLockTest rt = new ReentrantLockTest();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                rt.method2();
            }).start();
        }
    }
}
