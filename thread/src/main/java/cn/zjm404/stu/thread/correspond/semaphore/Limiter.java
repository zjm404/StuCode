package cn.zjm404.stu.thread.correspond.semaphore;

import java.util.concurrent.Semaphore;

public class Limiter implements IThreadPool{
    private Semaphore s;
    private IThreadPool threadPool;
    public Limiter(int permits,IThreadPool _threadPool){
        s = new Semaphore(permits);
        this.threadPool = _threadPool;
    }

    @Override
    public void execute(Runnable work) throws InterruptedException {
        s.acquire();
        try{
            threadPool.execute(work);
        }finally {
            s.release();
        }

    }
}
