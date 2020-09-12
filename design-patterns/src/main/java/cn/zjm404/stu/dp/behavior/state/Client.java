package cn.zjm404.stu.dp.behavior.state;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(Context.STATE1);
        context.handle();
    }
}
