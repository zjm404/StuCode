package github.zjm404.stu.demo.timing;

import java.util.concurrent.*;

public class TimedTaskDemo{
    public static void doTask(Runnable r,long initialDelay,int period,TimeUnit timeUnit){
        ScheduledThreadPoolExecutor threads = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        threads.scheduleAtFixedRate(r,initialDelay,period,timeUnit);
    }
}
