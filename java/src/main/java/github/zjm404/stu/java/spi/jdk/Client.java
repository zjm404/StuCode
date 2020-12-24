package github.zjm404.stu.java.spi.jdk;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SPI，测试
 * @author zjm
 * @date 2020/12/10
 */
public class Client {
    public static void main(String[] args) {
        ServiceLoader<IDemo> demos = ServiceLoader.load(IDemo.class);
        for (IDemo demo : demos) {
            demo.say();
        }
    }
}
