package cn.zjm404.stu.multithreading.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunnableImpl target1 = new RunnableImpl();
        Thread thread = new Thread(target1);
        thread.start();

        CallableImpl target2 = new CallableImpl();
        FutureTask<String> ft = new FutureTask<>(target2);
        Thread thread2 = new Thread(ft);
        thread2.start();
        System.out.println(ft.get());

        Thread thread3 = new ThreadExtends();
        thread3.start();
    }

}
