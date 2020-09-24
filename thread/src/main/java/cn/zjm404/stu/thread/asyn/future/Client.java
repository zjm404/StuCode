package cn.zjm404.stu.thread.asyn.future;

import java.util.concurrent.ExecutionException;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyMeal myMeal = new MyMeal();
        myMeal.eat();
    }
}
