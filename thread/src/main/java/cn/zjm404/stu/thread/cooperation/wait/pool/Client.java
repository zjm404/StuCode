package cn.zjm404.stu.thread.cooperation.wait.pool;

public class Client {
    public static void main(String[] args) throws InterruptedException {
//        try {
//
//            ZhengXinChickenChopShop.sellChickenChop();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ZhengXinChickenChopShop.sellChickenChop1();
        Thread.sleep(100);
    }
}
