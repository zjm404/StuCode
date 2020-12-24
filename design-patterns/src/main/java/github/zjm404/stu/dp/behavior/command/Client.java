package github.zjm404.stu.dp.behavior.command;

public class Client {
    public static void main(String[] args) {
        ICommand command = new ConcreteCommand1();
        command.execute();
    }
}
