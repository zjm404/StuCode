package github.zjm404.stu.dp.behavior.observer;

/**
 * 进行业务
 */
public class ConcreteSubject extends Subject{
    public void doSomething(){
        super.notifyObservers();
    }
}
