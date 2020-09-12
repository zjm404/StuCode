package cn.zjm404.stu.thread.divide.pool.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threads = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }
}
