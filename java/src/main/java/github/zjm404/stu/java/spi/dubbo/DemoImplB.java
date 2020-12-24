package github.zjm404.stu.java.spi.dubbo;

/**
 * @author zjm
 * @date 2020/12/10
 */

public class DemoImplB implements IDemo{
    @Override
    public void say() {
        System.out.println("HELLO WORLD");
    }
}
