package github.zjm404.stu.demo.rpc.v1;

/**
 * @Author
 * @Date 2020/11/6
 * @Description
 * @Version 1.0
 */
public class DemoImpl implements IDemo{
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
