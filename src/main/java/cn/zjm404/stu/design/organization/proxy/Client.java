package cn.zjm404.stu.design.organization.proxy;

public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Subject());
        proxy.method();
    }
}
