package cn.zjm404.stu.dp.behavior.observer;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject cs = new ConcreteSubject();
        Observer obs = new ConcreteObserver();
        cs.addObserver(obs);
        cs.doSomething();
    }
}
