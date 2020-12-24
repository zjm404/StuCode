package github.zjm404.stu.thread.cooperation.semaphore;

public class TPMThreadPool implements IThreadPool{
    @Override
    public void execute(Runnable work) {
        new Thread(work).start();
    }
}
