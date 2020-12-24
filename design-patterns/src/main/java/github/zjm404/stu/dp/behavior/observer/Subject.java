package github.zjm404.stu.dp.behavior.observer;

import java.util.Vector;

/**
 * 观察者抽象类
 */
public abstract class Subject {
    /**
     * 存储观察者
     */
    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer _observer){
        observers.add(_observer);
    }

    public void delObserver(Observer _observer){
        observers.remove(_observer);
    }

    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
