package github.zjm404.stu.demo.di.bean;

public class ConcreteMsg implements IMsg{
    @Override
    public String getMsg() {
        return "hello world";
    }
}
