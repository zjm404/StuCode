package cn.zjm404.stu.design.creat.factory.factory;

import cn.zjm404.stu.design.creat.factory.AbstractProduct;
import cn.zjm404.stu.design.creat.factory.ConcreteProduct1;

public class ConcreteFactory1 extends AbstractFactory{

    @Override
    public AbstractProduct create() {
        return new ConcreteProduct1();
    }
}
