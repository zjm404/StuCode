package cn.zjm404.stu.dp.behavior.model;

public abstract class AbstractClass {
    public final void templateMethod(){
        method1();
        method2();
    }
    protected abstract void method1();
    protected abstract void method2();
}
