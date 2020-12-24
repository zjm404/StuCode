package github.zjm404.stu.thread.lock.cas;

public class Client {
    public static void main(String[] args) {
        CASDemo casDemo = new CASDemo(1);
        Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println(casDemo.increaseAndGet());
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(target).start();
        }

    }
}
