package cn.zjm404.stu.design.creat.factory.factory;

import cn.zjm404.stu.design.creat.factory.AbstractProduct;
import cn.zjm404.stu.design.creat.factory.ConcreteProduct2;

public class ConcreteFactory2 extends AbstractFactory{
    @Override
    public AbstractProduct create(){
        return new ConcreteProduct2();
    }
}
