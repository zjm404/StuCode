package cn.zjm404.stu.thread.lock.stamped;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    private final StampedLock sl = new StampedLock();

    public void read(){
        //先进行乐观读
        //用于判断读取时是否有线程修改共享资源
        long stamp = sl.tryOptimisticRead();
        //进行读取操作
        //...
        if(!sl.validate(stamp)){
            //升级为悲观锁
            stamp  = sl.readLock();
            try{
                //进行读操作
                //...
            }finally {
                //释放悲观锁
                sl.unlockRead(stamp);
            }
        }

    }

    public void write(){
        long stamp = sl.writeLock();
        try{
            //进行写
            //...
        }finally {
            sl.unlockWrite(stamp);
        }
    }
}
