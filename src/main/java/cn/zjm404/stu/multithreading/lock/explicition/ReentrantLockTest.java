package cn.zjm404.stu.multithreading.lock.explicition;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZJM
 */
public class ReentrantLockTest {
    private final ReentrantLock lock = new ReentrantLock();
    public void method(){
        lock.lock();
        try{
            //...执行任务
        }finally {
            lock.unlock();
        }
    }
}
