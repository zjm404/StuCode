package github.zjm404.stu.dp.behavior.command;

public class ConcreteCommand1 implements ICommand{
    @Override
    public void execute() {
        System.out.println("hello world");
    }
}
