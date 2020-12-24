package github.zjm404.stu.thread.divide.worker;

import java.util.concurrent.BlockingQueue;

public class WorkerThreadTest {
    private final BlockingQueue<Runnable> works;
    public WorkerThreadTest(BlockingQueue _works,int _threadNum){
        this.works = _works;
        for (int i = 0; i < _threadNum; i++) {
            new Thread(()->{
                //使线程一直运行，阻止线程销毁
                while(true){
                    synchronized(this){
                        if(!works.isEmpty()){
                            works.poll().run();
                        }
                    }
                }
            }).start();
        }
    }
    public void execute(Runnable work){
        if(null == work){
            throw new NullPointerException("任务不可以为 null");
        }
        works.add(work);
    }
}
