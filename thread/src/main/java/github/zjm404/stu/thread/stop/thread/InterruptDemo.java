package github.zjm404.stu.thread.stop.thread;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    //避免一个实例启动多个线程
    private boolean started = false;
    //执行任务的线程
    private Thread t;

    public synchronized void run(){
        if(started){
            return;
        }
        started = true;
        t = new Thread(()->{
            int i = 1;
            while(!Thread.currentThread().isInterrupted()){

                System.out.printf("执行任务中~~ 第%d次执行 \n",i++);

                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch(InterruptedException e) {
                    //JVM 异常处理会清除状态，所以捕捉到异常后需要重设状态
                    Thread.currentThread().interrupt();
                }
            }
            started = false;
        });
        t.start();
    }

    public synchronized void stop(){
        t.interrupt();
    }

}
