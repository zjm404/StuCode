package cn.zjm404.stu.dp.behavior.visitor;

public interface Visitor {
    public void doSomething(ConcreteObject1 co1);
    public void doSomething(ConcreteObject2 co2);
}
