package cn.zjm404.stu.design.organization.bridge;

public class ConcreteAClass extends AbstractAClass{
    public ConcreteAClass(IExtendsClass iExtendsClass) {
        super(iExtendsClass);
    }

    @Override
    public void method() {
        //...
    }
}
