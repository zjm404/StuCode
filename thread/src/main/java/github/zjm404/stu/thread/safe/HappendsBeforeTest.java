package github.zjm404.stu.thread.safe;

/**
 * @author ZJM
 */
public class HappendsBeforeTest {
    private static int i =0;
    private volatile static boolean j = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            i = 1;
            j = true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            if(j){
                System.out.println(i);
            }else{
                System.out.println("wait...");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
