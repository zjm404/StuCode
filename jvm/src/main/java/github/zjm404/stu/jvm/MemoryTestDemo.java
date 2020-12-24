package github.zjm404.stu.jvm;

/**
 * 仅用于学习 JVM 内存划分，并无实际意义
 */
public class MemoryTestDemo {
    public static int num;
    public final int NUM = 1;
    private Msg msg;

    public MemoryTestDemo(Msg msg) {
        this.msg = msg;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }
}
