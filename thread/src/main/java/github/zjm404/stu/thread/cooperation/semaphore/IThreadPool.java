package github.zjm404.stu.thread.cooperation.semaphore;

public interface IThreadPool {
    public void execute(Runnable work) throws InterruptedException;
}
