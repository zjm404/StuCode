package cn.zjm404.stu.dp.behavior.observer;

public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        System.out.println("被观察者进行了修改...开始更新依赖值...");
    }
}
