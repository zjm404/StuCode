package github.zjm404.stu.dp.behavior.visitor;

public class ConcreteObject2 extends AbstractObject {

    @Override
    public void accept(Visitor visitor) {
        visitor.doSomething(this);
    }
}
