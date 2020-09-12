package cn.zjm404.stu.dp.behavior.memento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Originator {
    private int id;
    private String msg;

    public Memento createMemento(){
        return new Memento(id,msg);
    }
    public void restoreMemento(Memento memento){
        this.id = memento.getId();
        this.msg = memento.getMsg();
    }
}
