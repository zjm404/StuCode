package github.zjm404.stu.thread.cooperation.wait.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {
    public static void main(String[] args){
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        ZhengXinChickenChopShop shop = new ZhengXinChickenChopShop(poolExecutor);
        shop.sellChickenChop2();
        poolExecutor.shutdown();
    }
}
