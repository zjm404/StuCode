package cn.zjm404.stu.thread.correspond.semaphore;

public class TPMThreadPool implements IThreadPool{
    @Override
    public void execute(Runnable work) {
        new Thread(work).start();
    }
}
