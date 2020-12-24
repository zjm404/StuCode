package github.zjm404.stu.thread.lock.explicition;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZJM
 */
public class ReentrantLockTest {
    private final ReentrantLock lock = new ReentrantLock();
    public void method1(){
        lock.lock();
        try{
            //...执行任务
            System.out.println("hello world");
        }finally {
            lock.unlock();
        }
    }
    public void method2(){
        lock.lock();
        try{
            method1();
        }finally {
            lock.unlock();
        }
    }
}
