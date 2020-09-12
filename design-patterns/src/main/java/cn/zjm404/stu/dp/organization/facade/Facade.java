package cn.zjm404.stu.dp.organization.facade;

public class Facade {
    private Sub1 sub1 = new Sub1();
    private Sub2 sub2 = new Sub2();

    public void method1(){
        sub1.do1();
    }
    public void method2(){
        sub2.do2();
    }
}
