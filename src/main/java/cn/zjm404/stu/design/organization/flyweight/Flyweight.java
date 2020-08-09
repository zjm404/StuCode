package cn.zjm404.stu.design.organization.flyweight;

public class Flyweight {
    //非共享属性
    private String a1;
    private int a2;
    //共享属性
    private final SharedObject SHARED_OBJECT;

    public Flyweight(String _a1,int _a2,SharedObject _SHARED_OBJECT){
        this.a1 = _a1;
        this.a2 = _a2;
        this.SHARED_OBJECT = _SHARED_OBJECT;
    }

    public void method(){
        //业务逻辑
    }

}
