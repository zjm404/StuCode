package cn.zjm404.stu.thread.lock.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache<K,V> {
    private final Map<K,V> cache = new HashMap<>();
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    /**
     * 读缓存
     * @param key
     * @return 查询到的数据
     */
    public V get(K key){
        //上读锁
        r.lock();
        try{
            return cache.get(key);
        }finally {
            //释放读锁
            r.unlock();
        }
    }

    /**
     * 写缓存
     * @param key
     * @param value
     */
    public void put(K key,V value){
        //获取写锁
        w.lock();
        try{
            cache.put(key,value);
        }finally {
            //释放写锁
            w.unlock();
        }
    }
    
}
