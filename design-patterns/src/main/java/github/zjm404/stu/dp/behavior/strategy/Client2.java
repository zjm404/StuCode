package github.zjm404.stu.dp.behavior.strategy;

public class Client2 {
    public static void main(String[] args) {
        IStrategy strategy2 = StrategyFactory2.getStrategy(ConcreteStrategy1.class);
        strategy2.doSomething();

        IStrategy strategy1 = StrategyFactory1.getStrategy("A");
        strategy1.doSomething();
    }
}
