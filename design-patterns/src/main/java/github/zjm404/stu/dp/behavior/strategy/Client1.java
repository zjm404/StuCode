package github.zjm404.stu.dp.behavior.strategy;

public class Client1 {
    public static void main(String[] args) {
        IStrategy strategy = new ConcreteStrategy1();
        strategy.doSomething();
    }
}
