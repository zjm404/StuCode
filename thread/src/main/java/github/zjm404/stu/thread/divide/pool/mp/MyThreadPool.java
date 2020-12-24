package github.zjm404.stu.thread.divide.pool.mp;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyThreadPool {
    /**
     * 任务队列
     */
    private BlockingQueue<Runnable> works;
    /**
     * 保持活跃的线程数
     */
    private int CORE_THREADS;
    /**
     * 最大线程数
     */
    private int MAX_THREADS;

    private TimeUnit tu;

    private long times;

    private ArrayList<MyThread> threads = new ArrayList<>();

    private Lock tLock = new ReentrantLock();

    private abstract class MyThread extends Thread{
        private Runnable task;
        public MyThread(Runnable _task){
            this.task = _task;
        }
        public MyThread(){

        }

        @Override
        public void run() {
        }
    }
    private class MyCoreThread extends MyThread{
        private volatile boolean isInterrupt = false;

        public MyCoreThread(){
            super();
        }
        public MyCoreThread(Runnable task){
            super(task);
        }
        @Override
        public void run() {
            while(!isInterrupt){
                //如果 task 为 null,阻塞在获取任务中
                if(super.task == null){
                    super.task = works.poll();
                }
                super.task.run();
                super.task = null;
            }
        }
        public void myStop(){
            this.isInterrupt = true;
        }
    }

    private class MySimpleThread extends MyThread{
        private TimeUnit tu;
        private long times;

        public MySimpleThread(Runnable task,TimeUnit _tu,long _times){
            this.tu = _tu;
            this.times = _times;
            super.task = task;
        }
        @Override
        public void run() {
            super.task.run();
            try {
                tu.sleep(times);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public MyThreadPool(BlockingQueue _works,int _core,int _max){
        this(_works,_core,_max,TimeUnit.SECONDS,2);
    }
    public MyThreadPool(BlockingQueue _works,int _core,int _max,TimeUnit _tu,long _times){
        this.works = _works;
        this.CORE_THREADS = _core;
        this.MAX_THREADS = _max;
        this.tu = _tu;
        this.times = _times;
    }


    public void execute(Runnable task){
        //先判断传值是否合规
        if(task == null){
            throw new IllegalArgumentException("传空值警告！");
        }
        //因为可能要修改 threads,并且创建线程与增加线程节点这个过程应该是原子性的
        //所以使用锁，而不是使用线程安全的集合框架代替
        tLock.lock();
        try {
            //判断当前线程数量
            if(threads.size() < MAX_THREADS){
                MyThread mt;
                //如果未达到核心线程数，就创建核心线程
                if(threads.size() < CORE_THREADS){
                    mt = new MyCoreThread(task);
                }else{
                    mt = new MySimpleThread(task,tu,times);
                }
                threads.add(mt);
                return;
            }
        }finally {
            tLock.unlock();
        }
        //超过最大线程数量，先将任务放入阻塞队列中
        works.add(task);
    }

}
