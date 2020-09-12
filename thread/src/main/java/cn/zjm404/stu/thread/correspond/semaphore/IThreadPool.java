package cn.zjm404.stu.thread.correspond.semaphore;

public interface IThreadPool {
    public void execute(Runnable work) throws InterruptedException;
}
