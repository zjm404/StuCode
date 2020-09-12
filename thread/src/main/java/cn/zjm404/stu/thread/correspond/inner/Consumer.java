package cn.zjm404.stu.thread.correspond.inner;

public class Consumer implements Runnable{
    private Resource resource;
    public Consumer(Resource _resource){
        this.resource = _resource;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                resource.consume();
                System.out.println(i+"消费者消费了商品...");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
