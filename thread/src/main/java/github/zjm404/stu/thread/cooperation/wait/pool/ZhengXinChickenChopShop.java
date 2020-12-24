package github.zjm404.stu.thread.cooperation.wait.pool;

import java.util.concurrent.*;

public class ZhengXinChickenChopShop {
    private ThreadPoolExecutor tp;

    public ZhengXinChickenChopShop(ThreadPoolExecutor tp){
        this.tp = tp;
    }
    private void getDrink(){
        System.out.println("配置饮料");
    }
    private void getChickenChop(){
        System.out.println("炸鸡排");
    }

    /**
     * 使用 CountDownLatch
     */
    public void sellChickenChop1(){
        CountDownLatch ctl = new CountDownLatch(2);
        tp.execute(()->{
            getDrink();
            ctl.countDown();
        });
        tp.execute(()->{
            getChickenChop();
            ctl.countDown();
        });
        try {
            ctl.await();
        } catch (InterruptedException e) {
            Thread.currentThread().isInterrupted();
            e.printStackTrace();
        }
        System.out.println("打包，售出");
    }

    /**
     * 使用 CyclicBarrier
     */
    public void sellChickenChop2(){
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
