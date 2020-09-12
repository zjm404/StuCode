package cn.zjm404.stu.thread.safe;
public class AtomicTest {
    public static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        });
        Thread t2 = new Thread(()->{
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(i);
    }
}
