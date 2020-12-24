package github.zjm404.stu.thread.lock.rw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DowngradeLock {
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    private String msg;
    public void demo(){
        r.lock();
        try{
            //msg 为 null ,释放读锁，获取写锁，进行写入
            if(msg == null){
                r.unlock();
                w.lock();
                try{
                    //二次判断，看是否有线程更新过了
                    if(msg != null){
                        System.out.println(msg);
                        return;
                    }
                    msg = "hello world";
                    //锁降级
                    r.lock();
                }finally {
                    w.unlock();
                }
            }
            System.out.println("msg");
        }finally {
            //释放读锁
            r.unlock();
        }
    }
}
