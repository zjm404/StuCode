package github.zjm404.stu.thread.lock.rw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UpgradeLock {
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    private String msg;
    public void demo(){
        r.lock();
        try{
            w.lock();
            try {
                msg = "hello world";
            }finally {
                w.unlock();
            }
        }finally {
            r.unlock();
        }
    }
}
