package github.zjm404.stu.dp.behavior.memento;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setId(1);
        originator.setMsg("hello world");
        //添加快照 m1
        Memento m1 = originator.createMemento();
        caretaker.addMemento(m1);
        //修改值
        originator.setMsg("HELLO WORLD");
        //添加快照 m2
        Memento m2 = originator.createMemento();
        caretaker.addMemento(m2);
        //修改
        originator.setMsg("hello");
        //恢复到快照 m2
        originator.restoreMemento(caretaker.getMemento());
        //输出信息
        System.out.println(originator.getId());
        System.out.println(originator.getMsg());
    }
}
