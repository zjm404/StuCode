package cn.zjm404.stu.thread.cooperation.wait.thread;

public class Client {
    public static void main(String[] args) {
        ZhengXinChickenChopShop shop = new ZhengXinChickenChopShop();
        try {
            shop.sellChickenChop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
