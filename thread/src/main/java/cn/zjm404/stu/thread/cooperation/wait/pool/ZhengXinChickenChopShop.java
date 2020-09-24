package cn.zjm404.stu.thread.cooperation.wait.pool;

import java.util.concurrent.*;

public class ZhengXinChickenChopShop {
    private static final ThreadPoolExecutor tp = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    private static void getDrink(){
        System.out.println("配置饮料");
    }
    private static void getChickenChop(){
        System.out.println("炸鸡排");
    }
    public static void sellChickenChop() throws InterruptedException {
        CountDownLatch ctl = new CountDownLatch(2);
        tp.execute(()->{

            getDrink();
            ctl.countDown();
        });
        tp.execute(()->{

            getChickenChop();
            ctl.countDown();
        });
        ctl.await();
        System.out.println("打包，售出");
    }
    public static void sellChickenChop1(){
        CyclicBarrier cb = new CyclicBarrier(2,()->{
            System.out.println("打包，售出");
        });
        tp.execute(()->{
            getDrink();
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        tp.execute(()->{
            getChickenChop();
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
    }
}
