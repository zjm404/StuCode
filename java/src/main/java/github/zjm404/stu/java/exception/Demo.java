package github.zjm404.stu.java.exception;

/**
 * @author
 * @date 2020/12/18
 */
public class Demo {
    public void SubRun(){
        throw new RuntimeException("测试");
    }
    public void run() throws NullPointerException{
        SubRun();
        System.out.println("hello world");
    }
}
