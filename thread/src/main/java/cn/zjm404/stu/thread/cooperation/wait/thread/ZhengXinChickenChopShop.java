package cn.zjm404.stu.thread.cooperation.wait.thread;

public class ZhengXinChickenChopShop {
    private void getDrink(){
        System.out.println("配置饮料");
    }
    private void getChickenChop(){
        System.out.println("炸鸡排");
    }
    public void sellChickenChop() throws InterruptedException {
        Thread t1 = new Thread(()->{
            this.getChickenChop();
        });
        Thread t2 = new Thread(()->{
            this.getDrink();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("打包，售出");
    }
}
