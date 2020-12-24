package github.zjm404.stu.java.spi.jdk;

/**
 * SPI,接口实现类
 * @author zjm
 * @date 2020/12/10
 */
public class DemoImplA implements IDemo {
    @Override
    public void say() {
        System.out.println("hello world");
    }
}
