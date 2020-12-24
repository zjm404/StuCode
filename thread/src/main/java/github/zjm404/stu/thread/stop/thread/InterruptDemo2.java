package github.zjm404.stu.thread.stop.thread;

import java.util.concurrent.TimeUnit;

public class InterruptDemo2 {
    //自定义标志位,使用 volatile 保证可见性
    private volatile boolean isTerminated = false;
    private boolean started = false;
    private Thread t;

    //用于测试
    public Thread getThread(){
        return t;
    }
    private void subTask(){
        System.out.println("子任务进行中~");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            //捕捉到了异常，但是并没有重置中断状态
        }

    }

    public synchronized void run(){
        if(started){
            return;
        }
        started = true;
        t = new Thread(()->{
            int i = 1;
            while(!isTerminated){

                System.out.printf("执行任务中~~ 第%d次执行 \n",i++);


                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                subTask();
            }
            started = false;
        });
        t.start();
    }

    public synchronized void stop(){
        isTerminated = true;
    }
}
