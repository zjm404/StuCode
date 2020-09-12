package cn.zjm404.stu.dp.behavior.visitor;

public class Executor implements Visitor{
    @Override
    public void doSomething(ConcreteObject1 co1) {
        System.out.println("co1 执行");
    }
    @Override
    public void doSomething(ConcreteObject2 co2) {
        System.out.println("co2 执行");
    }
}
