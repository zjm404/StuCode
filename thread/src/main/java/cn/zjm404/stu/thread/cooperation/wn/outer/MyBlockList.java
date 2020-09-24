package cn.zjm404.stu.thread.cooperation.wn.outer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockList<T> {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final List<T> list = new LinkedList<>();
    private final int MAX_LEN = 8;

    public void add(T t){
        lock.lock();
        try{
            while(list.size() == MAX_LEN){
                notFull.await();
            }
            list.add(t);
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void remove(int i){
        lock.lock();
        try{
            while(list.size() == 0){
                notEmpty.await();
            }
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
