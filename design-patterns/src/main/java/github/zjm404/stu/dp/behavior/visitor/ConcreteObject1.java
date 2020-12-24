package github.zjm404.stu.dp.behavior.visitor;

public class ConcreteObject1 extends AbstractObject{

    @Override
    public void accept(Visitor visitor) {
        visitor.doSomething(this);
    }
}
