package cn.zjm404.stu.dp.behavior.memento;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> mementos;
    public Caretaker(){
        mementos = new Stack<>();
    }
    public void addMemento(Memento memento){
        mementos.push(memento);
    }
    public Memento getMemento(){
        return mementos.pop();
    }
}
