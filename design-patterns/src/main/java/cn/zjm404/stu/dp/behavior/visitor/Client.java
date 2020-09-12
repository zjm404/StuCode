package cn.zjm404.stu.dp.behavior.visitor;

public class Client {
    public static void main(String[] args) {
        AbstractObject ao = new ConcreteObject1();
        Executor executor = new Executor();
//        executor.doSomething(ao);
        ao.accept(executor);
    }
}
