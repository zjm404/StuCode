package github.zjm404.stu.thread.asyn.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MyMeal {
    public void eat() throws ExecutionException, InterruptedException {
        FutureTask<String> getHotWaterTask = new FutureTask<>(()->{
            System.out.println("T1: 烧热水中~~~");
            Thread.sleep(2);
            return "T1: 烧热水成功";
        });
        new Thread(getHotWaterTask).start();
        System.out.println("T2: 拆封");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T2: 撒料");
        TimeUnit.SECONDS.sleep(1);
        String res = getHotWaterTask.get();
        System.out.println(res);
        System.out.println("T2: 倒热水");
        System.out.println("T2: 等待~~");
        Thread.sleep(1);
        System.out.println("T2: 没有技术总结，直接开吃！");
    }
}
