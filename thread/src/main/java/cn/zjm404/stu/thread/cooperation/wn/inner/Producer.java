package cn.zjm404.stu.thread.cooperation.wn.inner;

public class Producer implements Runnable{
    private Resource resource;
    public Producer(Resource _resource){
        this.resource = _resource;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                resource.produce(new Object());
                System.out.println(i+"生产者生产了商品...");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
