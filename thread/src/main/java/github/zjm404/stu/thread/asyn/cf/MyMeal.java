package github.zjm404.stu.thread.asyn.cf;

import java.util.concurrent.CompletableFuture;

public class MyMeal {
    public void eat(){
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            System.out.println("t1: 烧热水中~~");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "水烧开了~";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println("t2: 拆封");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2: 撒料");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "泡面准备完成~~";
        });
        CompletableFuture<String> cf3 = cf1.thenCombine(cf2,(tf1, tf2)->{
            System.out.println(tf1);
            System.out.println(tf2);
            return "开吃";
        });
        System.out.println(cf3.join());
    }
}
